package com.example.alvaro.canvasdemo;

/**
 * Created by Alvaro on 1/22/2016.
 */
public class Point3D {
    public float x = 0;
    public float y = 0;
    public int z = 0;

    public Point3D getPointInPixels(int pixelPerMetre){
        Point3D point = new Point3D();
        point.x = x * pixelPerMetre;
        point.y = y * pixelPerMetre;
        point.z = z;

        return point;
    }
}

