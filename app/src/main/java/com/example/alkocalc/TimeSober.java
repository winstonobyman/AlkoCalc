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

public class TimeSober extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sober);
    }

    public void onTimeSoberCalculateClick(View view) {
        RadioButton eatenNo = findViewById(R.id.rb_eaten_no);
        final EditText etStrength = findViewById(R.id.et_strength);
        final EditText etVolume = findViewById(R.id.et_volume);

        if (TextUtils.isEmpty(etStrength.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Не забудь указать крепость!", Toast.LENGTH_SHORT);
            toast.show();
        } else if (TextUtils.isEmpty(etVolume.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Не забудь указать объём!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            int strength = Integer.parseInt(etStrength.getText().toString());
            int volume = Integer.parseInt(etVolume.getText().toString());
            boolean eaten = !eatenNo.isChecked();

            Intent intent = new Intent(this, TimeSoberResult.class);
            intent.putExtra("strength", strength);
            intent.putExtra("volume", volume);
            intent.putExtra("eaten", eaten);
            startActivity(intent);
            }
        }
    }
