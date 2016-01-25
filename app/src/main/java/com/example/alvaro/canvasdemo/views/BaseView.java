package com.example.alvaro.canvasdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.alvaro.canvasdemo.InputController;
import com.example.alvaro.canvasdemo.Viewport;
import com.example.alvaro.canvasdemo.objects.BaseObject;
import com.example.alvaro.canvasdemo.objects.SnowFlakes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alvaro on 1/22/2016.
 */
public abstract class BaseView extends SurfaceView implements Runnable{

    private volatile boolean running;
    private Thread thread = null;

    protected Paint paint;
    protected Canvas canvas;
    private SurfaceHolder holder;

    private Context context;

    protected Viewport vp;
    protected InputController ic;

    private long startFrameTime;
    private long timeThisFrame;
    protected long fps;

    protected ArrayList<BaseObject> objects;

    public abstract void update();
    public abstract void draw();

    public BaseView(Context context, int screenWidth, int screenHeight) {
        super(context);
        this.context = context;

        holder = getHolder();
        paint = new Paint();

        vp = new Viewport(screenWidth, screenHeight);

        objects = new ArrayList<BaseObject>();
    }

    @Override
    public void run() {
        while (running) {
            startFrameTime = System.currentTimeMillis();
            updateView();
            drawView();

            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
            }
        }
    }

    private void updateView() {
        if (fps != 0) {
            update();
        }
    }

    private final void drawView() {
        if (holder.getSurface().isValid()) {
            //First we lock the area of memory we will be drawing to
            canvas = holder.lockCanvas();

            // Rub out the last frame with arbitrary color
            paint.setColor(Color.argb(255, 0, 0, 0));
            canvas.drawColor(Color.argb(255, 0, 0, 0));

            if (fps != 0){
                draw();
            }

            // Unlock and draw the scene
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public final void pause() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            Log.e("ASCT", "Failed to pause Thread");
        }

        Log.e("ASCT", "Thread Stop");
    }

    public final void resume() {
        running = true;
        thread = new Thread(this);
        thread.start();

        Log.e("ASCT", "Thread Start");
    }
}