package com.example.jab6677.healthcalculators;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bmrButton = (Button) findViewById(R.id.bmrButton);
        bmrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMR.class);
                startActivity(intent);
            }
        });

        Button bmiButton = (Button) findViewById(R.id.bmiButton);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMI.class);
                startActivity(intent);
            }
        });

        Button bfButton = (Button) findViewById(R.id.bfButton);
        bfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BodyFatPercent.class);
                startActivity(intent);
            }
        });

        Button macroButton = (Button) findViewById(R.id.macroButton);
        macroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMI.class);
                startActivity(intent);
            }
        });
    }
}
