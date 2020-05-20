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

    }

    public void onBackClick(View view)  {
        RadioButton isMaleRb = (RadioButton) findViewById(R.id.r_sex_m);
        EditText ed = (EditText) findViewById(R.id.et_weight);
        boolean isMale = false;
        int weight;

        if (TextUtils.isEmpty(ed.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Не забудь указать вес!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            weight = Integer.parseInt(ed.getText().toString());


            if (isMaleRb.isChecked()) {
                isMale = true;
            }

            SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("weight", weight);
            editor.putBoolean("isMale", isMale);

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Данные пола и веса изменены", Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(this, ChooseFunction.class);
            startActivity(intent);
            editor.apply();
        }
    }
}
