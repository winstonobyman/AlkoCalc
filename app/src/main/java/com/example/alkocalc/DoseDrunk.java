package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
/**
 * Класс экрана вычисления количества выпитого
 */
public class DoseDrunk extends AppCompatActivity {

    int conditionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dose_drunk);

        Spinner spCondition = findViewById(R.id.sp_condition);
        String[] conditions = getResources().getStringArray(R.array.conditions);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, conditions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCondition.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener =
                new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conditionIndex = position;
             }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spCondition.setOnItemSelectedListener(itemSelectedListener);
    }

    public void onDoseDrunkCalculateClick(View view) {
        RadioButton eatenNo = findViewById(R.id.rb_eaten_no2);
        EditText etStrength = findViewById(R.id.et_strength2);

        if (TextUtils.isEmpty(etStrength.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Не забудь указать крепость!", Toast.LENGTH_SHORT);
            toast.show();
        } else if (Integer.parseInt(etStrength.getText().toString()) > 100 ||
                Integer.parseInt(etStrength.getText().toString()) <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Крепость от 0 до 100!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            int strength = Integer.parseInt(etStrength.getText().toString());

            boolean eaten = !eatenNo.isChecked();

            Intent intent = new Intent(this, DoseDrunkResult.class);
            intent.putExtra("strength", strength);
            intent.putExtra("eaten", eaten);
            intent.putExtra("conditionIndex", conditionIndex);
            startActivity(intent);
        }

    }
}
