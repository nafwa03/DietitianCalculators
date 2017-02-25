package com.example.nafwa03.dietitiancalculators;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.Switch;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity {

	Checkable bmiCheck, bmrCheck, csodiumCheck;
    Switch mOnOffBMI;
    Switch mOnOffBMR;
    Switch mOnOffCS;
    Switch mOnOffMifflin;
	Button mSubmitBtn;

	public static final String MyPREFERENCES = "MyPrefs";
	public static final Boolean BMI = true;
	public static final Boolean BMR = true;
	public static final Boolean CSodium = true;
	public static final String OnOffBMI = "BMIKey";
    public static final String OnOffBMR = "BMRKey";
    public static final String OnOffCS = "CSKey";
    public static final String OnOffMifflin = "MifflinKey";

	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.example.nafwa03.dietitiancalculators.R.layout.settings_main);
		mSubmitBtn = (Button) findViewById(com.example.nafwa03.dietitiancalculators.R.id.btnSubmit);

        /*
        Step 1
        To use android shared preference we have to call method  getSharedPreferences() that returns
         a SharedPreference instance poiting to the file that contains the values of preferences.
         The first parameter is the key and the second parameter is the MODE as shown below,
         */
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


		//bmiCheck = (Checkable) findViewById(R.id.bmiCheck);
		//bmrCheck = (Checkable) findViewById(R.id.bmrCheck);
		//csodiumCheck = (Checkable) findViewById(R.id.csodiumCheck);
        mOnOffBMI = (Switch) findViewById(com.example.nafwa03.dietitiancalculators.R.id.onOffBMI);
        mOnOffBMR = (Switch) findViewById(com.example.nafwa03.dietitiancalculators.R.id.onOffBMR);
        mOnOffCS = (Switch) findViewById(com.example.nafwa03.dietitiancalculators.R.id.onOffCS);
        mOnOffMifflin = (Switch) findViewById(com.example.nafwa03.dietitiancalculators.R.id.onOffMifflin);
        /*
        Step 3 : Get data from sharedpreference
          sharedpreferences.getString() method should be used to get the values for corresponding keys as shown below
         */

		if (sharedpreferences.contains(String.valueOf(OnOffBMI))) {
            mOnOffBMI.setChecked(sharedpreferences.getBoolean(OnOffBMI, false));
		}
        if (sharedpreferences.contains(String.valueOf(OnOffBMR))) {
            mOnOffBMR.setChecked(sharedpreferences.getBoolean(OnOffBMR, false));
        }
        if (sharedpreferences.contains(String.valueOf(OnOffCS))) {
            mOnOffCS.setChecked(sharedpreferences.getBoolean(OnOffCS, false));
        }
        if (sharedpreferences.contains(String.valueOf(OnOffMifflin))) {
            mOnOffMifflin.setChecked(sharedpreferences.getBoolean(OnOffMifflin, false));
        }
		/*
		if (sharedpreferences.contains(Email)) {
			mEmailEt.setText(sharedpreferences.getString(Email, ""));
		}

		if (sharedpreferences.contains(Phone)) {
			mPhoneEt.setText(sharedpreferences.getString(Phone, ""));
		}
		if (sharedpreferences.contains(Password)) {
			mPasswordEt.setText(sharedpreferences.getString(Password, ""));
		}

		if (sharedpreferences.contains(ConfirmPassword)) {
			mConfirmPasswordEt.setText(sharedpreferences.getString(ConfirmPassword, ""));
		}
		if (sharedpreferences.contains(String.valueOf(OnOffSwitch))) {
			mOnOffSwtc.setChecked(sharedpreferences.getBoolean(OnOffSwitch, false));
		}
		*/

		mSubmitBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				String n = mNameEt.getText().toString();
				String ph = mPhoneEt.getText().toString();
				String e = mEmailEt.getText().toString();
				String pw = mPasswordEt.getText().toString();
				String cpw = mConfirmPasswordEt.getText().toString();
				*/
				Boolean onoffBMI = mOnOffBMI.isChecked();
                Boolean onoffBMR = mOnOffBMR.isChecked();
                Boolean onoffCS = mOnOffCS.isChecked();
                Boolean onoffMifflin = mOnOffMifflin.isChecked();


                /*
                Step 2 : Save object to sharedpreferences
         We can save data to sharedpreferences using SharedPreferences.Editor class, for which we need to use edit method of the shared preference.
                 */
				SharedPreferences.Editor editor = sharedpreferences.edit();

				//editor.putString(Name, n);
				//editor.putString(Phone, ph);
				//editor.putString(Email, e);
				//editor.putString(Password, pw);
				editor.putBoolean(OnOffBMI, onoffBMI);
                editor.putBoolean(OnOffBMR, onoffBMR);
                editor.putBoolean(OnOffCS, onoffCS);
                editor.putBoolean(OnOffMifflin, onoffMifflin);
				//editor.putString(ConfirmPassword, cpw);
				editor.apply();

				Toast.makeText(SettingsActivity.this, "Settings Saved", Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
			}
		});
	}


}