package com.example.alvaro.canvasdemo.objects;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.alvaro.canvasdemo.Point3D;
import com.example.alvaro.canvasdemo.Viewport;

/**
 * Created by Alvaro on 1/22/2016.
 */
public abstract class BaseObject {
    private Point3D worldLocation;
    private float width;
    private float height;
    private float angle;

    public BaseObject(){
        worldLocation = new Point3D();
    }

    public abstract void update(Viewport vp, long fps);
    public abstract void draw(Viewport vp, Canvas canvas, Paint paint);

    public Point3D getWorldLocation() {
        return worldLocation;
    }

    public void setWorldLocation(float x, float y, int z) {
        this.worldLocation = new Point3D();
        this.worldLocation.x = x;
        this.worldLocation.y = y;
        this.worldLocation.z = z;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
