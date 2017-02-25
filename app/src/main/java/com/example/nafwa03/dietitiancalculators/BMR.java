package com.example.nafwa03.dietitiancalculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BMR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_bmr);

        final TextView heightUnit = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.heightUnit);
        final TextView weightUnit = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.weightUnit);
        final Button button = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.submit);
        final TextView resultArea = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.bmiResult);

        RadioGroup radioGroup = (RadioGroup) findViewById(com.example.nafwa03.dietitiancalculators.R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case com.example.nafwa03.dietitiancalculators.R.id.imperial:
                        heightUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.inches);
                        weightUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.pounds);
                        break;
                    case com.example.nafwa03.dietitiancalculators.R.id.metric:
                        heightUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.cm);
                        weightUnit.setText(com.example.nafwa03.dietitiancalculators.R.string.kg);
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double bmr;
                    boolean isMale = true;
                    int age  = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.ageValue)).getText().toString());
                    int height = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.heightValue)).getText().toString());
                    int weight = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.weightValue)).getText().toString());
                    RadioGroup sexGroup = (RadioGroup) findViewById(com.example.nafwa03.dietitiancalculators.R.id.radiogroupSex);
                    RadioButton checked = (RadioButton)findViewById(sexGroup.getCheckedRadioButtonId());
                    switch (checked.getId()) {
                        case com.example.nafwa03.dietitiancalculators.R.id.male:
                            isMale = true;
                            break;
                        case com.example.nafwa03.dietitiancalculators.R.id.female:
                            isMale = false;
                            break;
                    }

                    if ((heightUnit.getText().toString()).equals("Inches")){
                        bmr = calculateBMRImperial((double) height,(double) weight,age, isMale);
                    }
                    else{
                        bmr = calculateBMRMetric((double) height,(double) weight, age, isMale);
                    }
                    resultArea.setText("Your base metabolic rate is: "+bmr+" calories burnt a day while at rest.");
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for height, weight, and age.");
                }
            }
        });
    }

    public double calculateBMRMetric(double height, double weight, int age, boolean isMale){
        if(isMale) {
            return (10 * weight) + (6.25 * height) - (5 * age) + 5;
        }
        else{
            return (10 * weight) + (6.25 * height) - (5 * age) + 161;
        }
    }
    public double calculateBMRImperial(double height, double weight, int age, boolean isMale){
        weight*= 0.453592;
        height*=2.54;
        return calculateBMRMetric(height, weight, age, isMale);
    }
}
