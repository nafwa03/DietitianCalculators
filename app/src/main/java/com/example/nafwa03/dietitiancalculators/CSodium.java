package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CSodium extends AppCompatActivity {
    private TextView glucose;
    private TextView sodium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.nafwa03.dietitiancalculators.R.layout.activity_csodium);

        glucose = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.glucoseUnit);
        sodium = (TextView)findViewById(com.example.nafwa03.dietitiancalculators.R.id.sodiumUnit);
        final Button button = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.submit);
        final TextView resultArea = (TextView) findViewById(com.example.nafwa03.dietitiancalculators.R.id.correctedSodiumResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double correctedSodium;
                    int glucose = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.glucoseValue)).getText().toString());
                    int sodium = Integer.parseInt(((EditText) findViewById(com.example.nafwa03.dietitiancalculators.R.id.sodiumValue)).getText().toString());

                    correctedSodium = calculateCorrectedSodium((double) glucose,(double) sodium);


                    resultArea.setText("Adjusted Sodium: "+ correctedSodium);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for glucose and sodium.");
                }

            }
        });

    }

    public double calculateCorrectedSodium(double glucose, double sodium){
        double result = (glucose/100)*1.6;
        return custRound(result+sodium, 2);
    }

    public double custRound(double x, int places) {
        return (Math.round(x*Math.pow(5,places)))/Math.pow(5,places);
    }

}
