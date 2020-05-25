package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChangeAttrs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_attrs);
        EditText ed = (EditText) findViewById(R.id.et_weight2);

        RadioButton rbMale = findViewById(R.id.r_sex_m2);
        RadioButton rbWoman = findViewById(R.id.r_sex_w2);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        float weight = prefs.getFloat("weight", (float) 0.0);
        boolean male = prefs.getBoolean("male", false);

        ed.setText(Float.toString(weight));

        if (male) {
            rbMale.setChecked(true);
        } else {
            rbWoman.setChecked(true);
        }
    }

    public void onBackClick(View view)  {
        RadioButton isMaleRb = findViewById(R.id.r_sex_m2);
        EditText ed = findViewById(R.id.et_weight2);
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

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Данные пола и веса изменены", Toast.LENGTH_SHORT);
            toast.show();
            editor.apply();
            Intent intent = new Intent(this, ChooseFunction.class);
            startActivity(intent);
        }
    }
}
