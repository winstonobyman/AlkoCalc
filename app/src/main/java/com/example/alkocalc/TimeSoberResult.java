package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TimeSoberResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sober_result);
    }

    public void onBackClick(View view) {
        Intent intent = new Intent(this, ChooseFunction.class);
        startActivity(intent);
    }
}
