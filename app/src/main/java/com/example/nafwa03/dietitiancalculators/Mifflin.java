package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Mifflin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_mifflin);

        final Button button = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.submit);
        final TextView resultArea = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.bmiResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double mifflin;
                    boolean isMale = true;
                    int age  = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.ageValue)).getText().toString());
                    int height = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.heightValue)).getText().toString());
                    int weight = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.weightValue)).getText().toString());
                    int sf = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.SF)).getText().toString());
                    double weight2 = (weight/2.2)*10;
                    double height2 =  (height*2.54)*6.25;
                    int age2 = age*5;
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

                        mifflin = calculateMifflin(height2, weight2, age2, (double) sf, isMale);

                    resultArea.setText("TEE: "+mifflin+" ");
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for height, weight, age, and stress factor.");
                }
            }
        });
    }

    public double calculateMifflin(double height, double weight, int age, double sf, boolean isMale){
        if(isMale) {

            return ((weight + height) - age - 5)*sf;
        }
        else{
            return ((weight + height) - age - 161)*sf;
        }
    }

}
