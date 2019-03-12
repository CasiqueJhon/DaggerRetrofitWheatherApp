package com.jhonisaac.daggerretrofitwheatherapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity2 extends AppCompatActivity {

    public static final String TEMPERATURE = "temperature";

    public static final String TEMPERATURE_INT = "temperature_int";

    @Inject
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ((BaseApplication )getApplication()).plusSharedPreferencesSubComponent().inject(this);

        //to write in sharedpref
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(TEMPERATURE, "21º");
        prefEditor.putInt(TEMPERATURE_INT, 0);
        prefEditor.apply();

        //to read from sharedPref
        String temperature = sharedPreferences.getString(TEMPERATURE, "DEFAULT");
        int temperature_int = sharedPreferences.getInt(TEMPERATURE_INT, 0 );
        Toast.makeText(this, "Temperature " + temperature +
                "Temperature Int " + temperature_int, Toast.LENGTH_SHORT).show();


    }
}
