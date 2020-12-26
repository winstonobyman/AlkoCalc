package com.example.alkocalc.welcome_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.alkocalc.R;

/**
 * Класс второго экрана
 */
public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
    }

    /**
     * Переход на следующую страницу с ограничениями на ввод
     * @param view View
     */
    public void onNext2Click(View view) {
        RadioButton isMaleRb = (RadioButton) findViewById(R.id.r_sex_m);
        EditText ed = (EditText) findViewById(R.id.et_weight);
        boolean isMale = false;
        float weight;

        if (TextUtils.isEmpty(ed.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Не забудь указать вес!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            weight = Float.parseFloat(ed.getText().toString());


            if (isMaleRb.isChecked()) {
                isMale = true;
            }

            SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat("weight", weight);
            editor.putBoolean("male", isMale);
            editor.apply();

            Intent intent = new Intent(this, ThirdScreen.class);
            startActivity(intent);
        }
    }
}
