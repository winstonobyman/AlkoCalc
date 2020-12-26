package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alkocalc.utils.DiaryUtils;
import com.example.alkocalc.welcome_screens.FirstScreen;

/**
 * Класс главного экрана приложения
 */
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

    /**
     * Метод перехода на экран изменения настроек
     * @param view View
     */
    public void onChangeClick(View view) {
        startActivity(new Intent(this, ChangeAttrs.class));
    }

    /**
     * Метод перехода на экран вычисления времени выздоровления
     * @param view View
     */
    public void onTimeSoberClick(View view) {
        startActivity(new Intent(this, TimeSober.class));
    }

    /**
     * Метод перехода на экран вычисления дозы
     * @param view View
     */
    public void onDoseDrunkClick(View view) {
        startActivity(new Intent(this, DoseDrunk.class));
    }

    /**
     * Метод перехода на экран дневника
     * @param view View
     */
    public void onDateDiaryClick(View view) {
        startActivity(new Intent(this, DateDiary.class));
    }

    /**
     * Метод перехода на экран информации
     * @param view View
     */
    public void onInfoPanelClick(View view) { startActivity(new Intent(this, InfoPanel.class)); }

    /**
     * Метод перехода на экран поиска вин
     * @param view View
     */
    public void onWineSearchClick(View view) { startActivity(new Intent(this, WineSearch.class)); }
}
