package com.example.alvaro.canvasdemo;

/**
 * Created by rubymobile on 1/25/16.
 */
public class Point2D {
    public float x = 0;
    public float y = 0;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D getPointInPixels(int pixelPerMetre){
        Point2D point = new Point2D(x * pixelPerMetre,y * pixelPerMetre);
        return point;
    }
}
