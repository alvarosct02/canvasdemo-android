package com.example.alvaro.canvasdemo.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.alvaro.canvasdemo.Point3D;
import com.example.alvaro.canvasdemo.Viewport;

import java.util.Random;

/**
 * Created by rubymobile on 1/25/16.
 */
public class Curve extends BaseObject {

//    Random random = new Random();
//    private float ANGLE_RANGE = 0.2f;
//    private float size;
//    private float distance;

    private float x2,y2;

    public Curve(float x, float y){
        super();

        x2 = x;
        y2 = y;
        setWorldLocation(x,y,0);
//        setAngle(angle);
    }


    @Override
    public void draw(Viewport vp, Canvas canvas, Paint paint) {
//        Point3D pos = getWorldLocation().getPointInPixels(vp.getPixelsPerMetre());

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3.0f);
        paint.setAntiAlias(true);

        paint.setColor(Color.BLACK);


        float x1 = getWorldLocation().x;
        float y1 = getWorldLocation().y;
        float x3 = 17;
        float y3 = 20;

        Path path = new Path();
        path.moveTo(x1 * vp.getPixelsPerMetre(), y1 * vp.getPixelsPerMetre());

        path.quadTo(x2, y2 , x3 * vp.getPixelsPerMetre(), y3 * vp.getPixelsPerMetre());
        canvas.drawPath(path, paint);

        canvas.drawCircle(x2,y2,5,paint);


    }

    public void setBezier(float x, float y){
        x2 = x;
        y2 = y;
    }

    @Override
    public void update(Viewport vp, long fps) {

    }
}
