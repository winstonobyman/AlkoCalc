package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_panel);
    }

    public void onBackClick(View view) {
        startActivity(new Intent(this, ChooseFunction.class));
    }
}
