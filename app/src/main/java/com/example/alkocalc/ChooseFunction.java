package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alkocalc.prefsutils.DiaryUtils;

import java.util.Date;

public class ChooseFunction extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;


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

    @Override
    protected void onResume() {
        DiaryUtils.loadEditTextNote(this, (EditText) findViewById(R.id.editTextNote));
        super.onResume();
    }

    @Override
    protected void onStop() {
        DiaryUtils.saveEditTextNote(this, (EditText) findViewById(R.id.editTextNote));
        super.onStop();
    }

    public void onChangeClick(View view) {
        startActivity(new Intent(this, ChangeAttrs.class));
    }

    public void onTimeSoberClick(View view) {
        startActivity(new Intent(this, TimeSober.class));
    }

    public void onDoseDrunkClick(View view) {
        startActivity(new Intent(this, DoseDrunk.class));
    }

    public void onDateDiaryClick(View view) {
        startActivity(new Intent(this, DateDiary.class));
    }

    public void onInfoPanelClick(View view) {
        startActivity(new Intent(this, InfoPanel.class));
    }

    public void onVineSearchClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "To be done", Toast.LENGTH_SHORT);
        toast.show();
    }
}
