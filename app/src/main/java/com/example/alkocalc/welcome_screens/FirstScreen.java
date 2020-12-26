package com.example.alkocalc.welcome_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alkocalc.R;

/**
 * Класс первого экрана
 */
public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }

    public void onClickBsc1Next(View view) {
        Intent intent = new Intent(this, SecondScreen.class);
        startActivity(intent);
    }
}
