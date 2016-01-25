package com.example.alvaro.canvasdemo.views;

import android.content.Context;
import android.graphics.Color;

import com.example.alvaro.canvasdemo.objects.BaseObject;
import com.example.alvaro.canvasdemo.objects.SnowFlakes;

import java.util.Random;

/**
 * Created by Alvaro on 1/22/2016.
 */
public class SnowView extends BaseView {

    Random random = new Random();

    public SnowView(Context context, int screenWidth, int screenHeight) {
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

        paint.setColor(Color.argb(255, 0, 64, 255));
        canvas.drawColor(Color.argb(255, 0, 64, 255));

        for (BaseObject obj : objects) {
            obj.draw(vp,canvas,paint);
        }

    }
}
