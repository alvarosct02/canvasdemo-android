package com.example.alvaro.canvasdemo.activities;

import android.graphics.Point;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.alvaro.canvasdemo.views.BaseView;
import com.example.alvaro.canvasdemo.views.SnowView;

public class SnowActivity extends AppCompatActivity {

    BaseView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point resolution = new Point();
        display.getSize(resolution);

        // And finally set the view for our game
        view = new SnowView(this, resolution.x, resolution.y);

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
