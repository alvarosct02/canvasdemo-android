package com.example.alvaro.canvasdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.example.alvaro.canvasdemo.Point2D;
import com.example.alvaro.canvasdemo.objects.BaseObject;
import com.example.alvaro.canvasdemo.objects.SnowFlakes;

import java.util.Random;

/**
 * Created by rubymobile on 1/25/16.
 */
public class FullView extends BaseView {

    Random random = new Random();

    public FullView(Context context, int screenWidth, int screenHeight) {
        super(context, screenWidth, screenHeight);

        for(int i = 0; i < 200; i++){
            float x = random.nextFloat()* vp.getMetresToShowX();
            float y = random.nextFloat()* vp.getMetresToShowY();
            objects.add(new SnowFlakes(x,y));
        }
    }


    @Override
    public void update() {
        for (BaseObject obj : objects) {
            obj.update(vp,fps);
        }
    }

    @Override
    public void draw() {

        paint.setColor(Color.argb(255, 13, 13, 39));
        canvas.drawColor(Color.argb(255, 13, 13, 39));

        drawSky(new Point2D(0,2), new Point2D(3.175f,-1.55f), new Point2D(9,5.425f), new Point2D(vp.getMetresToShowX(),2),Color.parseColor("#0C104A") );

        paint.reset();

        for (BaseObject obj : objects) {
            obj.draw(vp,canvas,paint);
        }

    }

    private void drawSky(Point2D p1, Point2D p2, Point2D p3, Point2D p4, int color){

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        p1 = p1.getPointInPixels(vp.getPixelsPerMetre());
        p2 = p2.getPointInPixels(vp.getPixelsPerMetre());
        p3 = p3.getPointInPixels(vp.getPixelsPerMetre());
        p4 = p4.getPointInPixels(vp.getPixelsPerMetre());

        Path path = new Path();
        path.moveTo(0,vp.getMetresToShowY()*vp.getPixelsPerMetre());
        path.lineTo(p1.x, p1.y);
        path.cubicTo(p2.x, p2.y,p3.x, p3.y,p4.x, p4.y);
        path.lineTo(vp.getMetresToShowX() * vp.getPixelsPerMetre(),vp.getMetresToShowY() * vp.getPixelsPerMetre());
        path.close();
        canvas.drawPath(path, paint);
    }
}
