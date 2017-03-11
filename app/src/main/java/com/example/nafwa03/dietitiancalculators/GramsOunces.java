package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GramsOunces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramsounces);

        final TextView ozUnit = (TextView)findViewById(R.id.ounceUnit);
        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.ozTOgmResult);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case R.id.ozTOgm:
                        ozUnit.setText(R.string.ounces);
                        resultArea.setText("");
                        break;
                    case R.id.gmTOoz:
                        ozUnit.setText(R.string.grams);
                        resultArea.setText("");
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double ozTogmconversion;
                    String unit;
                    int convertValue = Integer.parseInt(((EditText) findViewById(R.id.convertValue)).getText().toString());
                    if ((ozUnit.getText().toString()).equals("Ounces")){
                        ozTogmconversion = calculateOZtoGM((double) convertValue);
                        unit = " grams";
                    }
                    else{
                        ozTogmconversion = calculateGMtoOZ((double) convertValue);
                        unit = " ounces";
                    }
                    resultArea.setText(ozTogmconversion + unit);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper value.");
                }

            }
        });

    }

    public double calculateOZtoGM(double convertValue){
        double result = convertValue / 28.35;
        return result;
    }
    public double calculateGMtoOZ(double convertValue){
        double result = convertValue * 28.35;
        return result;
    }



}
