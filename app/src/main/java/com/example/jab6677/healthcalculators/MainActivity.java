package com.example.jab6677.healthcalculators;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences savedValues;
    private SharedPreferences prefs;
    private boolean showBMI = true;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context mContext;
        //SharedPreferences pref = getApplicationContext().getSharedPreferences("preferences_calculators", 0); // 0 - for private mode
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        /*
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("bmiLogo", true); // Storing boolean - true/false
        editor.commit(); // commit changes
        */
        showBMI = sharedpreferences.getBoolean("BMIKey",false); // getting boolean
        Log.d("BMI is", String.valueOf(showBMI));


            Button bmrButton = (Button) findViewById(R.id.bmrButton);
            bmrButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), BMR.class);
                    startActivity(intent);
                }
            });

            Button bmiButton = (Button) findViewById(R.id.bmiButton);
        if(!showBMI) {
            bmiButton.setVisibility(View.GONE);
        }
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

        Button mifflinButton = (Button) findViewById(R.id.mifflinBtn);
        mifflinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mifflin.class);
                startActivity(intent);
            }
        });

        Button cSodiumButton = (Button) findViewById(R.id.cSodiumButton);
        cSodiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CSodium.class);
                startActivity(intent);
            }
        });

        Button milligramButton = (Button) findViewById(R.id.milligramBtn);
        milligramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Milligram.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

/*
    @Override
    public void onPause() {
        // save the instance variables
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putBoolean("bmiLogo", showBMI);
        //editor.putFloat("tipPercent", tipPercent);
        editor.apply();

        super.onPause();

        Log.d("SAVED VALUES", "onPause executed");
    }
*/
}
