package com.example.alvaro.canvasdemo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alvaro.canvasdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSnow = (Button)findViewById(R.id.btnSnow);
        btnSnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SnowActivity.class);
                startActivity(intent);
            }
        });


        Button btnCurve = (Button)findViewById(R.id.btnCurve);
        btnCurve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CurveActivity.class);
                startActivity(intent);
            }
        });

        Button btnFull = (Button)findViewById(R.id.btnFull);
        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FullActivity.class);
                startActivity(intent);
            }
        });
    }
}
