package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class WHO extends AppCompatActivity {
//TODO: Lazy implementation must fix calc function
    private boolean isMale;
    private boolean under3;
    private boolean threeToten;
    private boolean tenToeighteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);


        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.WHOResult);

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
                        resultArea.setText("");
                        break;
                    case R.id.female:
                        isMale = false;
                        resultArea.setText("");
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
                        resultArea.setText("");
                        break;
                    case R.id.threeTOten:
                        threeToten = true;
                        under3 = false;
                        tenToeighteen = false;
                        resultArea.setText("");
                        break;
                    case R.id.tenTOeighteen:
                        tenToeighteen = true;
                        under3 = false;
                        threeToten = false;
                        resultArea.setText("");
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double WHO = 0.0;
                    double weightfactor;
                    double agefactor;
                    int weight = Integer.parseInt(((EditText) findViewById(R.id.weightValue)).getText().toString());

                    if(isMale && under3) {
                        weightfactor = 60.9;
                        agefactor = 54;
                        WHO = (weightfactor*weight)-agefactor;
                    }
                    if (!isMale && under3) {
                        weightfactor = 61.0;
                        agefactor = 51;
                        WHO = (weightfactor*weight)-agefactor;
                    }
                    if (isMale && threeToten) {
                        weightfactor = 22.7;
                        agefactor = 495;
                        WHO = (weightfactor*weight)+agefactor;
                    }
                    if (!isMale && threeToten) {
                        weightfactor = 22.5;
                        agefactor = 499;
                        WHO = (weightfactor*weight)+agefactor;
                    }
                    if (isMale && tenToeighteen) {
                        weightfactor = 17.5;
                        agefactor = 651;
                        WHO = (weightfactor*weight)+agefactor;
                    }
                    if (!isMale && tenToeighteen) {
                        weightfactor = 12.2;
                        agefactor = 746;
                        WHO = (weightfactor*weight)+agefactor;
                    }

                    resultArea.setText(Double.toString(WHO));

                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for weight");
                }
            }
        });
    }


}
