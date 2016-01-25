package com.example.alvaro.canvasdemo.activities;

import android.graphics.Point;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.alvaro.canvasdemo.views.BaseView;
import com.example.alvaro.canvasdemo.views.SnowView;

public class SnowActivity extends AppCompatActivity {

    BaseView snowView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point resolution = new Point();
        display.getSize(resolution);

        // And finally set the view for our game
        snowView = new SnowView(this, resolution.x, resolution.y);

        // Make our platformView the view for the Activity
        setContentView(snowView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        snowView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        snowView.resume();
    }
}
