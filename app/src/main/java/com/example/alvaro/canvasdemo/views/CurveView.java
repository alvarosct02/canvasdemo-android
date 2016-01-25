package com.example.alvaro.canvasdemo.views;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;

import com.example.alvaro.canvasdemo.objects.BaseObject;
import com.example.alvaro.canvasdemo.objects.Curve;
import com.example.alvaro.canvasdemo.objects.SnowFlakes;

import java.util.Random;

/**
 * Created by rubymobile on 1/25/16.
 */
public class CurveView extends BaseView {

//    Random random = new Random();

    Curve curve;

    public CurveView(Context context, int screenWidth, int screenHeight) {
        super(context, screenWidth, screenHeight);

        curve = new Curve(0, 0);
        objects.add(curve);
    }

    @Override
    public void update() {
        for (BaseObject obj : objects) {
            obj.update(vp,fps);
        }
    }

    @Override
    public void draw() {

        paint.setColor(Color.argb(255, 50, 205, 205));
        canvas.drawColor(Color.argb(255, 50, 205, 205));

        for (BaseObject obj : objects) {
            obj.draw(vp, canvas, paint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        int pointerCount = motionEvent.getPointerCount();

        for (int i = 0; i < pointerCount; i++) {

            int x = (int) motionEvent.getX(i);
            int y = (int) motionEvent.getY(i);

            curve.setBezier(x,y);
//            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
//
//                case MotionEvent.ACTION_UP:
//                case MotionEvent.ACTION_POINTER_UP:
//                    curve.setBezier(x,y);
//
//                    break;
//            }
        }

        //invalidate();
        return true;
    }
}
