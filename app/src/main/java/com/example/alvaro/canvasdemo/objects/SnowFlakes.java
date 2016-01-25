package com.example.alvaro.canvasdemo.objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.alvaro.canvasdemo.Point3D;
import com.example.alvaro.canvasdemo.Viewport;

import java.util.Random;

/**
 * Created by Alvaro on 1/24/2016.
 */
public class SnowFlakes extends BaseObject {

    Random random = new Random();
    private float ANGLE_RANGE = 0.2f;
    private float size;
    private float distance;

    public SnowFlakes(float x, float y){
        super();

        distance = random.nextFloat()*3+2;
        size = random.nextFloat()*3+3;
        float angle = (float) (random.nextFloat() * ANGLE_RANGE + Math.PI/2 - ANGLE_RANGE/2);
        setWorldLocation(x,y,0);
        setAngle(angle);

    }


    @Override
    public void draw(Viewport vp, Canvas canvas, Paint paint) {
        Point3D pos = getWorldLocation().getPointInPixels(vp.getPixelsPerMetre());
        paint.setColor(Color.WHITE);
        canvas.drawCircle(pos.x, pos.y, size, paint);
    }

    @Override
    public void update(Viewport vp, long fps) {

        float x, y, angle;

        x = (float) (getWorldLocation().x + distance / fps * Math.cos(getAngle()));
        y = (float) (getWorldLocation().y + distance / fps * Math.sin(getAngle()));
        angle = getAngle() + (random.nextInt(2) - 1)/1000;

        setWorldLocation(x, y, getWorldLocation().z);
        setAngle(angle);


        if (getWorldLocation().y > vp.getMetresToShowY()) {
            y = 0;
            x = random.nextFloat() *  vp.getMetresToShowX();
            angle = (float) (random.nextInt(100) / 100 * ANGLE_RANGE + Math.PI / 2 - ANGLE_RANGE / 2);

            setWorldLocation(x, y, getWorldLocation().z);
            setAngle(angle);
        }
    }
}