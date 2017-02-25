package com.example.nafwa03.dietitiancalculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BodyFatPercent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_body_fat_percent);


        final RadioGroup sexGroup = (RadioGroup) findViewById(com.example.nafwa03.dietitiancalculators.R.id.radiogroupSex);
        final TextView weightUnit = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.weightUnit);
        final TextView waistUnit = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.waistUnit);
        final TextView wristLogo = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.wristLogo);
        final EditText wristValue = (EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.wristValue);
        final TextView wristUnit = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.wristUnit);
        final TextView hipLogo = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.hipLogo);
        final EditText hipValue = (EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.hipValue);
        final TextView hipUnit = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.hipUnit);
        final TextView forearmLogo = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.forearmLogo);
        final EditText forearmValue = (EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.forearmValue);
        final TextView forearmUnit = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.forearmUnit);
        final Button submitButton = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.submit);

        RadioGroup radioGroup = (RadioGroup) findViewById(com.example.nafwa03.dietitiancalculators.R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case com.example.nafwa03.dietitiancalculators.R.id.imperial:
                        weightUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.pounds);
                        waistUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.inches);
                        wristUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.inches);
                        hipUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.inches);
                        forearmUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.inches);
                        break;
                    case com.example.nafwa03.dietitiancalculators.R.id.metric:
                        weightUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.kg);
                        waistUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.cm);
                        wristUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.cm);
                        hipUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.cm);
                        forearmUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.cm);
                        break;
                }
            }
        });

        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                RelativeLayout.LayoutParams params;
                switch(checked)
                {
                    case com.example.nafwa03.dietitiancalculators.R.id.female:
                        wristLogo.setVisibility(View.VISIBLE);
                        wristValue.setVisibility(View.VISIBLE);
                        wristUnit.setVisibility(View.VISIBLE);
                        hipLogo.setVisibility(View.VISIBLE);
                        hipValue.setVisibility(View.VISIBLE);
                        hipUnit.setVisibility(View.VISIBLE);
                        forearmLogo.setVisibility(View.VISIBLE);
                        forearmValue.setVisibility(View.VISIBLE);
                        forearmUnit.setVisibility(View.VISIBLE);
                        params = (RelativeLayout.LayoutParams)submitButton.getLayoutParams();
                        params.addRule(RelativeLayout.BELOW, com.example.nafwa03.dietitiancalculators.R.id.forearmValue);
                        submitButton.setLayoutParams(params);
                        break;
                    case com.example.nafwa03.dietitiancalculators.R.id.male:
                        wristLogo.setVisibility(View.INVISIBLE);
                        wristValue.setVisibility(View.INVISIBLE);
                        wristUnit.setVisibility(View.INVISIBLE);
                        hipLogo.setVisibility(View.INVISIBLE);
                        hipValue.setVisibility(View.INVISIBLE);
                        hipUnit.setVisibility(View.INVISIBLE);
                        forearmLogo.setVisibility(View.INVISIBLE);
                        forearmValue.setVisibility(View.INVISIBLE);
                        forearmUnit.setVisibility(View.INVISIBLE);
                        params = (RelativeLayout.LayoutParams)submitButton.getLayoutParams();
                        params.addRule(RelativeLayout.BELOW, com.example.nafwa03.dietitiancalculators.R.id.waistValue);
                        submitButton.setLayoutParams(params);
                        break;
                }
            }
        });
    }
}
