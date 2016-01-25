package com.example.alvaro.canvasdemo.activities;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import com.example.alvaro.canvasdemo.views.BaseView;
import com.example.alvaro.canvasdemo.views.CurveView;
import com.example.alvaro.canvasdemo.views.SnowView;

public class CurveActivity extends AppCompatActivity {

    BaseView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        DisplayMetrics dm = new DisplayMetrics();
        display.getRealMetrics(dm);
        Log.e("ASCT", String.valueOf(dm.densityDpi));


        // Load the resolution into a Point object
        Point resolution = new Point();
        display.getSize(resolution);

        // And finally set the view for our game
        view = new CurveView(this, resolution.x, resolution.y);

        // Make our platformView the view for the Activity
        setContentView(view);
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.resume();
    }




}
