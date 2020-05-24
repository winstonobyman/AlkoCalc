package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alkocalc.calculations.FormulaUtils;
import com.example.alkocalc.calculations.TimeCalculator;

public class TimeSoberResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sober_result);

        Bundle arguments = getIntent().getExtras();
        int strength = arguments.getInt("strength");
        float percent = ((float)strength / 100);
        int volume = arguments.getInt("volume");
        boolean eaten = arguments.getBoolean("eaten");

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        float weight =  prefs.getFloat("weight", (float)0.0);
        boolean male = prefs.getBoolean("male", false);

        TimeCalculator timeCalculator = new TimeCalculator(percent, volume, eaten, weight, male);
        float hoursToSomber = FormulaUtils.round(timeCalculator.getSoberTime(), 1);
        int[] convertedTimeArray = FormulaUtils.getHoursMinutes(hoursToSomber);
        int hours = convertedTimeArray[0];
        int minutes = convertedTimeArray[1];

        float ppm = FormulaUtils.round(timeCalculator.getC(), 2);

        TextView tvDrinkInfo = findViewById(R.id.drink_info);
        TextView tvSoberTime = findViewById(R.id.sober_time);
        TextView tvPerMile = findViewById(R.id.per_mile);

        tvDrinkInfo.setText( getString(R.string.drink_result_time_info, volume, strength));
        if (hours == 0) {
            tvSoberTime.setText(getString(R.string.sober_minutes_digit, minutes));
        } else if (minutes == 0) {
            tvSoberTime.setText(getString(R.string.sober_hours_digit, hours));
        } else {
            tvSoberTime.setText(getString(R.string.sober_hours_minutes, hours, minutes));
        }
        tvPerMile.setText(getString(R.string.per_mile, ppm));
    }

    public void onBackClick(View view) {
        Intent intent = new Intent(this, ChooseFunction.class);
        startActivity(intent);
    }
}
