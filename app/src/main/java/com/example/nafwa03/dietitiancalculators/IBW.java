package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IBW extends AppCompatActivity {
//TODO: Lazy implementation must fix calc function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_ibw);

        final TextView heightUnit = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.heightUnit);
        final Button button = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.submit);
        final TextView resultArea = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.ibwResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String ibw;
                    boolean isMale = true;
                    int startweight = 0;
                    int factor = 0;
                    int height = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.heightValue)).getText().toString());
                    RadioGroup sexGroup = (RadioGroup) findViewById(com.example.nafwa03.dietitiancalculators.R.id.radiogroupSex);
                    RadioButton checked = (RadioButton)findViewById(sexGroup.getCheckedRadioButtonId());
                    switch (checked.getId()) {
                        case com.example.nafwa03.dietitiancalculators.R.id.male:
                            isMale = true;
                            startweight = 106;
                            factor = 6;
                            break;
                        case com.example.nafwa03.dietitiancalculators.R.id.female:
                            isMale = false;
                            startweight = 100;
                            factor = 5;
                            break;
                    }

                        ibw = calculateIBW((double) height, startweight, factor, isMale);

                    resultArea.setText(ibw);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for height");
                }
            }
        });
    }

    public String calculateIBW(double height, int startweight, int factor, boolean isMale){
        Double ibw = height-60;
        String smallframe = "Small Frame: ";
        String mediumframe = "Medium Frame: ";
        String largeframe = "Large Frame: ";
        Double mediumframevalue = startweight+(ibw*factor);
        Double smallframevalue = mediumframevalue-(mediumframevalue*0.10);
        Double largeframevalue = mediumframevalue+(mediumframevalue*0.10);
        if(isMale) {
            StringBuilder sb = new StringBuilder();
            sb.append(smallframe + smallframevalue);
            sb.append(System.getProperty("line.separator"));
            sb.append(mediumframe + mediumframevalue);
            sb.append(System.getProperty("line.separator"));
            sb.append(largeframe + largeframevalue);
            sb.append(System.getProperty("line.separator"));
            return sb.toString();
           // return (10 * weight) + (6.25 * height) - (5 * age) + 5;
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(smallframe + smallframevalue);
            sb.append(System.getProperty("line.separator"));
            sb.append(mediumframe + mediumframevalue);
            sb.append(System.getProperty("line.separator"));
            sb.append(largeframe + largeframevalue);
            sb.append(System.getProperty("line.separator"));
            return sb.toString();
        }
    }

}
