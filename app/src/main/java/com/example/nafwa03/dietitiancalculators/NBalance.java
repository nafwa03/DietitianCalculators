package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NBalance extends AppCompatActivity {
    private TextView grams;
    private TextView urea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbalance);

        grams = (TextView)findViewById(R.id.gramsUnit);
        urea = (TextView)findViewById(R.id.ureaUnit);
        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.nitrogenbalanceResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double nitrogenBalance;
                    int protein_grams = Integer.parseInt(((EditText) findViewById(R.id.proteinValue)).getText().toString());
                    int urinary_urea = Integer.parseInt(((EditText) findViewById(R.id.nitrogenValue)).getText().toString());

                    nitrogenBalance = calculateNitrogenBalance((double) protein_grams,(double) urinary_urea);


                    resultArea.setText("Nitrogen Balance: "+ nitrogenBalance);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for protein and urea nitrogen.");
                }

            }
        });

    }

    public double calculateNitrogenBalance(double protein_grams, double urinary_urea){
        double result = (protein_grams/6.25)-(urinary_urea+4);
        return custRound(result, 2);
    }

    public double custRound(double x, int places) {
        return (Math.round(x*Math.pow(5,places)))/Math.pow(5,places);
    }

}
