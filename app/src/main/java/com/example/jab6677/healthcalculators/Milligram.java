package com.example.jab6677.healthcalculators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Milligram extends AppCompatActivity {

    private EditText calcium;
    private TextView calcium_result;
    private EditText chlorine;
    private TextView chlorine_result;
    private EditText magnesium;
    private TextView magnesium_result;
    private EditText phosphorus;
    private TextView phosphorus_result;
    private EditText potassium;
    private TextView potassium_result;
    private EditText sodium;
    private TextView sodium_result;
    private EditText sulfur;
    private TextView sulfur_result;
    private EditText sulfate;
    private TextView sulfate_result;
    private EditText zinc;
    private TextView zinc_result;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meq);
        //TODO: Add switch for TextWatcher

        btnClear = (Button) findViewById(R.id.clear);

        calcium = (EditText) findViewById(R.id.mgCalcium);

        calcium_result = (TextView) findViewById(R.id.mEqCalcium);
        calcium.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                calcium_result.setText(calculateValence(calcium.getText().toString(), 40, 2));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        chlorine = (EditText) findViewById(R.id.mgChlorine);
        chlorine_result = (TextView) findViewById(R.id.mEqChlorine);
        chlorine.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                chlorine_result.setText(calculateValence(chlorine.getText().toString(),35.4, 1));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        magnesium = (EditText) findViewById(R.id.mgMagnesium);
        magnesium_result = (TextView) findViewById(R.id.mEqMagnesium);
        magnesium.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                magnesium_result.setText(calculateValence(magnesium.getText().toString(),24.3, 2));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        phosphorus = (EditText) findViewById(R.id.mgPhosphorus);
        phosphorus_result = (TextView) findViewById(R.id.mEqPhosphorus);
        phosphorus.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                phosphorus_result.setText(calculateValence(phosphorus.getText().toString(),31, 2));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        potassium = (EditText) findViewById(R.id.mgPotassium);
        potassium_result = (TextView) findViewById(R.id.mEqPotassium);
        potassium.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                potassium_result.setText(calculateValence(potassium.getText().toString(),39, 1));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        sodium = (EditText) findViewById(R.id.mgSodium);
        sodium_result = (TextView) findViewById(R.id.mEqSodium);
        sodium.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                sodium_result.setText(calculateValence(sodium.getText().toString(),23, 1));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        sulfur = (EditText) findViewById(R.id.mgSulfur);
        sulfur_result = (TextView) findViewById(R.id.mEqSulfur);
        sulfur.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                sulfur_result.setText(calculateValence(sulfur.getText().toString(),32, 2));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        sulfate = (EditText) findViewById(R.id.mgSulfate);
        sulfate_result = (TextView) findViewById(R.id.mEqSulfate);
        sulfate.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                sulfate_result.setText(calculateValence(sulfate.getText().toString(),96, 2));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        zinc = (EditText) findViewById(R.id.mgZinc);
        zinc_result = (TextView) findViewById(R.id.mEqZinc);
        zinc.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                zinc_result.setText(calculateValence(zinc.getText().toString(),65.4, 2));
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clearAll((ViewGroup) findViewById(R.id.tableLayout1));
            }
        });
    }

    public String calculateValence(String mineral, double atomic_weight, int valence ) {
        double milligram = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formatted;
        if (mineral.toString() != "" && mineral.toString().length() > 0) {
            milligram = Double.parseDouble(mineral.toString());
        }
            formatted = decimalFormat.format(milligram / atomic_weight * valence);
        return formatted;
           // return Integer.toString((int) (milligram / atomic_weight * valence));
    }

    public void clearAll(ViewGroup root) {
        for (int i = 0, j = root.getChildCount(); i < j; i++) {
            View view = root.getChildAt(i);
            if (view instanceof ViewGroup) {
                clearAll((ViewGroup) view);
                continue;
            }
            if (view instanceof EditText) {
                ((EditText) view).setText("");
                continue;
            }
        }
    }

}