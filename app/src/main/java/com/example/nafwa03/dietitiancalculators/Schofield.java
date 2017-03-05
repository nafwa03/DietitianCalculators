package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Schofield extends AppCompatActivity {
//TODO: Lazy implementation must fix calc function
    private boolean isMale;
    private boolean under3;
    private boolean threeToten;
    private boolean tenToeighteen;
    private boolean eighteenTothirty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schofield);


        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.schofieldResult);

        //No default radio values set to set variables on click

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroupSex);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case R.id.male:
                        isMale = true;
                        break;
                    case R.id.female:
                        isMale = false;
                        break;
                }
            }
        });
        RadioGroup radioGroupAge = (RadioGroup) findViewById(R.id.radiogroupAge);
        radioGroupAge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroupAge, int checked)
            {
                switch(checked)
                {
                    case R.id.under3:
                        under3 = true;
                        threeToten = false;
                        tenToeighteen = false;
                        eighteenTothirty = false;
                        break;
                    case R.id.threeTOten:
                        threeToten = true;
                        under3 = false;
                        tenToeighteen = false;
                        eighteenTothirty = false;
                        break;
                    case R.id.tenTOeighteen:
                        tenToeighteen = true;
                        under3 = false;
                        threeToten = false;
                        eighteenTothirty = false;
                        break;
                    case R.id.eighteenTOthirty:
                        eighteenTothirty = true;
                        under3 = false;
                        threeToten = false;
                        tenToeighteen = false;
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double schofield = 0.0;
                    double weightfactor;
                    double heightfactor;
                    double agefactor;
                    int height = Integer.parseInt(((EditText) findViewById(R.id.heightValue)).getText().toString());
                    int weight = Integer.parseInt(((EditText) findViewById(R.id.weightValue)).getText().toString());

                    if(isMale && under3) {
                        weightfactor = 0.167;
                        heightfactor = 15.174;
                        agefactor = 617.6;
                        schofield = (weightfactor*weight)+(heightfactor*height)-agefactor;
                    }
                    if (!isMale && under3) {
                        weightfactor = 16.252;
                        heightfactor = 10.232;
                        agefactor = 413.5;
                        schofield = (weightfactor*weight)+(heightfactor*height)-agefactor;
                    }
                    if (isMale && threeToten) {
                        weightfactor = 19.59;
                        heightfactor = 1.303;
                        agefactor = 414.9;
                        schofield = (weightfactor*weight)+(heightfactor*height)+agefactor;
                    }
                    if (!isMale && threeToten) {
                        weightfactor = 16.969;
                        heightfactor = 1.618;
                        agefactor = 371.2;
                        schofield = (weightfactor*weight)+(heightfactor*height)+agefactor;
                    }
                    if (isMale && tenToeighteen) {
                        weightfactor = 16.25;
                        heightfactor = 1.372;
                        agefactor = 515.5;
                        schofield = (weightfactor*weight)+(heightfactor*height)+agefactor;
                    }
                    if (!isMale && tenToeighteen) {
                        weightfactor = 8.365;
                        heightfactor = 4.65;
                        agefactor = 200.0;
                        schofield = (weightfactor*weight)+(heightfactor*height)+agefactor;
                    }
                    if (isMale && eighteenTothirty) {
                        weightfactor = 15.057;
                        heightfactor = 0.1;
                        agefactor = 705.8;
                        schofield = (weightfactor*weight)-(heightfactor*height)+agefactor;
                    }
                    if (!isMale && eighteenTothirty) {
                        weightfactor = 13.623;
                        heightfactor = 2.83;
                        agefactor = 98.2;
                        schofield = (weightfactor*weight)+(heightfactor*height)+agefactor;
                    }

                    resultArea.setText(Double.toString(schofield));

                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for height and weight");
                }
            }
        });
    }


}
