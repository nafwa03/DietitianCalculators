package com.example.nafwa03.dietitiancalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdjBodyWeight extends AppCompatActivity {
    private TextView abw;
    private TextView ibw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjbodyweight);

        abw = (TextView)findViewById(R.id.abwUnit);
        ibw = (TextView)findViewById(R.id.ibwUnit);
        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.adjbodyweightResult);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double adjBodyWeight;
                    int abw = Integer.parseInt(((EditText) findViewById(R.id.abwValue)).getText().toString());
                    int ibw = Integer.parseInt(((EditText) findViewById(R.id.ibwValue)).getText().toString());

                    adjBodyWeight = calculateAdjBodyWeight((double) abw,(double) ibw);


                    resultArea.setText("Adjusted Body Weight: "+ adjBodyWeight);
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for adjusted body weight and ideal body weight.");
                }

            }
        });

    }

    public double calculateAdjBodyWeight(double abw, double ibw){
        double result = (abw-ibw)*0.25+ibw;
        return custRound(result, 2);
    }

    public double custRound(double x, int places) {
        return (Math.round(x*Math.pow(5,places)))/Math.pow(5,places);
    }

}
