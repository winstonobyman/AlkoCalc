package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alkocalc.calculations.FormulaUtils;
import com.example.alkocalc.calculations.TimeCalculator;

public class DoseDrunkResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dose_drunk_result);


        TextView tvPerMileOutput = findViewById(R.id.tv_per_mile_output);
        TextView tvDrinkInfoOutput = findViewById(R.id.tv_drink_info_output);
        TextView tvSoberTimeOutput = findViewById(R.id.tv_sober_time_output);

        Bundle arguments = getIntent().getExtras();
        int strength = arguments.getInt("strength");
        float percent = ((float)strength / 100);
        boolean eaten = arguments.getBoolean("eaten");
        int conditionIndex = arguments.getInt("conditionIndex");

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        float weight =  prefs.getFloat("weight", (float)0.0);
        boolean male = prefs.getBoolean("male", false);

        String[] conditions = getResources().getStringArray(R.array.conditions);
        String[] conditionsScale = getResources().getStringArray(R.array.conditions_scale);

        float c = (float)((Float.parseFloat(conditionsScale[conditionIndex])
                                  + Float.parseFloat(conditionsScale[conditionIndex + 1]))/2);

        TimeCalculator timeCalculator = new TimeCalculator(c, weight, male, eaten, percent);
        int volume = timeCalculator.getVolume();
        float hoursToSomber = FormulaUtils.round(timeCalculator.getSoberTime(), 1);
        int[] convertedTimeArray = FormulaUtils.getHoursMinutes(hoursToSomber);
        int hours = convertedTimeArray[0];
        int minutes = convertedTimeArray[1];

        tvDrinkInfoOutput.setText( getString(R.string.drink_result_time_info, volume, strength));
        tvPerMileOutput.setText(conditions[conditionIndex]);
        if (hours == 0) {
            tvSoberTimeOutput.setText(getString(R.string.sober_minutes_digit, minutes));
        } else if (minutes == 0) {
            tvSoberTimeOutput.setText(getString(R.string.sober_hours_digit, hours));
        } else {
            tvSoberTimeOutput.setText(getString(R.string.sober_hours_minutes, hours, minutes));
        }
    }

    public void onBackClick (View view) {
        Intent intent = new Intent(this, ChooseFunction.class);
        startActivity(intent);
    }
}
