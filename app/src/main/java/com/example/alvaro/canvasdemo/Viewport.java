package com.example.alvaro.canvasdemo;

import android.graphics.Rect;

/**
 * Created by Alvaro on 1/22/2016.
 */
public class Viewport {

    private Point3D currentWorldCentre;
    private Rect convertedRect;
    private int pixelsPerMetre;
    private int screenXResolution;
    private int screenYResolution;
    private int screenCentreX;
    private int screenCentreY;
    private int metresToShowX;
    private int metresToShowY;
    private int numClipped;

    public Viewport(int x, int y){

        screenXResolution = x;
        screenYResolution = y;

        screenCentreX = screenXResolution / 2;
        screenCentreY = screenYResolution / 2;

        pixelsPerMetre = screenXResolution / 18;

        metresToShowX = 20;
        metresToShowY = 34;

        convertedRect = new Rect();
        currentWorldCentre = new Point3D();
    }

    void setWorldCentre(float x, float y){
        currentWorldCentre.x  = x;
        currentWorldCentre.y  = y;
    }


    public int getScreenWidth(){
        return  screenXResolution;
    }

    public int getScreenHeight(){
        return  screenYResolution;
    }

    public int getPixelsPerMetre(){
        return  pixelsPerMetre;
    }

    public Rect worldToScreen(float objectX, float objectY, float objectWidth, float objectHeight){
        int left = (int) (screenCentreX - ((currentWorldCentre.x - objectX) * pixelsPerMetre));
        int top =  (int) (screenCentreY - ((currentWorldCentre.y - objectY) * pixelsPerMetre));
        int right = (int) (left + (objectWidth * pixelsPerMetre));
        int bottom = (int) (top + (objectHeight * pixelsPerMetre));
        convertedRect.set(left, top, right, bottom);
        return convertedRect;
    }

    public boolean clipObjects(float objectX, float objectY, float objectWidth, float objectHeight) {
        boolean clipped = true;

        if (objectX < currentWorldCentre.x + (getMetresToShowX() / 2)) {
            if (objectX + objectWidth> currentWorldCentre.x - (getMetresToShowX() / 2)) {
                if (objectY < currentWorldCentre.y + (getMetresToShowY() / 2)) {
                    if (objectY + objectHeight > currentWorldCentre.y - (getMetresToShowY() / 2)){
                        clipped = false;
                    }

                }
            }
        }

        if(clipped){
            numClipped++;
        }

        return clipped;
    }

    public int getNumClipped(){
        return numClipped;
    }

    public void resetNumClipped(){
        numClipped = 0;
    }

    public int getMetresToShowX() {
        return metresToShowX;
    }

    public int getMetresToShowY() {
        return metresToShowY;
    }
}

