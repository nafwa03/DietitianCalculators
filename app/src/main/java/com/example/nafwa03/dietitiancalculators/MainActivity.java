package com.example.nafwa03.dietitiancalculators;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean showBMI = true;
    private boolean showBMR = true;
    private boolean showCS = true;
    private boolean showMifflin = true;
    public static final String MyPREFERENCES = "MyPrefs";
    //TODO: Create visibility function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_main);
        Context mContext;
        //SharedPreferences pref = getApplicationContext().getSharedPreferences("preferences_calculators", 0); // 0 - for private mode
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        showBMI = sharedpreferences.getBoolean("BMIKey",false); // getting boolean
        showBMR = sharedpreferences.getBoolean("BMRKey",false); // getting boolean
        showCS = sharedpreferences.getBoolean("CSKey",false); // getting boolean
        showMifflin = sharedpreferences.getBoolean("MifflinKey",false); // getting boolean
        Log.d("BMI is", String.valueOf(showBMI));


            Button bmrButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.bmrButton);
        if(!showBMR) {
            bmrButton.setVisibility(View.GONE);
        }
            bmrButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), BMR.class);
                    startActivity(intent);
                }
            });

            Button bmiButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.bmiButton);
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
        Button bfButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.bfButton);
        bfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BodyFatPercent.class);
                startActivity(intent);
            }
        });

        Button mifflinButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.mifflinBtn);
        if(!showMifflin) {
            mifflinButton.setVisibility(View.GONE);
        }
        mifflinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mifflin.class);
                startActivity(intent);
            }
        });

        Button cSodiumButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.cSodiumButton);
        if(!showCS) {
            cSodiumButton.setVisibility(View.GONE);
        }
        cSodiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CSodium.class);
                startActivity(intent);
            }
        });

        Button milligramButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.milligramBtn);
        milligramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Milligram.class);
                startActivity(intent);
            }
        });

        Button cCalciumButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.ccalciumBtn);
        cCalciumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CCalcium.class);
                startActivity(intent);
            }
        });

        Button ibwButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.hamwiBtn);
        ibwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IBW.class);
                startActivity(intent);
            }
        });

        Button vitDButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.vitDBtn);
        vitDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VitD.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.example.nafwa03.dietitiancalculators.R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case com.example.nafwa03.dietitiancalculators.R.id.menu_settings:
                //Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                return true;
            case com.example.nafwa03.dietitiancalculators.R.id.menu_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
