package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class VitD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitd);

        final TextView vitDUnit = (TextView)findViewById(R.id.vitDUnit);
        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.vitDResult);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case R.id.iuTOug:
                        vitDUnit.setText(R.string.iu);
                        resultArea.setText("");
                        break;
                    case R.id.ugTOiu:
                        vitDUnit.setText(R.string.ug);
                        resultArea.setText("");
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double vitDconversion;
                    String unit;
                    int vitD = Integer.parseInt(((EditText) findViewById(R.id.vitDValue)).getText().toString());
                    if ((vitDUnit.getText().toString()).equals("IU")){
                        vitDconversion = calculateIUtoug((double) vitD);
                        unit = " ug";
                    }
                    else{
                        vitDconversion = calculateugtoIU((double) vitD);
                        unit = " IU";
                    }
                    resultArea.setText(vitDconversion + unit);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for height and weight.");
                }

            }
        });

    }

    public double calculateIUtoug(double vitD){
        double result = vitD / 40;
        return result;
    }
    public double calculateugtoIU(double vitD){
        double result = vitD * 40;
        return result;
    }



}
