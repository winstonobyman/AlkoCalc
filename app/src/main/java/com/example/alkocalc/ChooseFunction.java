package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.sql.Time;

public class ChooseFunction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart)  {
            startActivity(new Intent(this, FirstScreen.class));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_function);
    }

    public void onChangeClick(View view) {
        startActivity(new Intent(this, ChangeAttrs.class));
    }

    public void onTimeSoberClick(View view) {
        startActivity(new Intent(this, TimeSober.class));
    }

}
