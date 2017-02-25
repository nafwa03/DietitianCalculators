package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CCalcium extends AppCompatActivity {
    private TextView albumin;
    private TextView calcium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_ccalcium);

        albumin = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.albuminUnit);
        calcium = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.calciumUnit);
        final Button button = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.submit);
        final TextView resultArea = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.correctedCalciumResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double correctedCalcium;
                    int albumin = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.albuminValue)).getText().toString());
                    int calcium = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.calciumValue)).getText().toString());

                    correctedCalcium = calculateCorrectedCalcium((double) albumin,(double) calcium);


                    resultArea.setText("Adjusted Calcium: "+ correctedCalcium);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for albumin and calcium.");
                }

            }
        });

    }

    public double calculateCorrectedCalcium(double albumin, double calcium){
        double result = (4.0-albumin)*0.8+calcium;
        return custRound(result, 2);
    }

    public double custRound(double x, int places) {
        return (Math.round(x*Math.pow(5,places)))/Math.pow(5,places);
    }

}
