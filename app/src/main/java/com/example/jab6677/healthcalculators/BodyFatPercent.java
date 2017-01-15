package com.example.jab6677.healthcalculators;

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
        setContentView(R.layout.activity_body_fat_percent);


        final RadioGroup sexGroup = (RadioGroup) findViewById(R.id.radiogroupSex);
        final TextView weightUnit = (TextView)findViewById(R.id.weightUnit);
        final TextView waistUnit = (TextView)findViewById(R.id.waistUnit);
        final TextView wristLogo = (TextView) findViewById(R.id.wristLogo);
        final EditText wristValue = (EditText) findViewById(R.id.wristValue);
        final TextView wristUnit = (TextView) findViewById(R.id.wristUnit);
        final TextView hipLogo = (TextView) findViewById(R.id.hipLogo);
        final EditText hipValue = (EditText) findViewById(R.id.hipValue);
        final TextView hipUnit = (TextView) findViewById(R.id.hipUnit);
        final TextView forearmLogo = (TextView) findViewById(R.id.forearmLogo);
        final EditText forearmValue = (EditText) findViewById(R.id.forearmValue);
        final TextView forearmUnit = (TextView) findViewById(R.id.forearmUnit);
        final Button submitButton = (Button) findViewById(R.id.submit);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case R.id.imperial:
                        weightUnit.setText(R.string.pounds);
                        waistUnit.setText(R.string.inches);
                        wristUnit.setText(R.string.inches);
                        hipUnit.setText(R.string.inches);
                        forearmUnit.setText(R.string.inches);
                        break;
                    case R.id.metric:
                        weightUnit.setText(R.string.kg);
                        waistUnit.setText(R.string.cm);
                        wristUnit.setText(R.string.cm);
                        hipUnit.setText(R.string.cm);
                        forearmUnit.setText(R.string.cm);
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
                    case R.id.female:
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
                        params.addRule(RelativeLayout.BELOW, R.id.forearmValue);
                        submitButton.setLayoutParams(params);
                        break;
                    case R.id.male:
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
                        params.addRule(RelativeLayout.BELOW, R.id.waistValue);
                        submitButton.setLayoutParams(params);
                        break;
                }
            }
        });
    }
}
