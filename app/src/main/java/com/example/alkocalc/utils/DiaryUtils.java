package com.example.alkocalc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.alkocalc.entity.Record;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Класс с методами для работы со списком записей и запиской
 */

public class DiaryUtils {

    /**
     * Метод для сохранения списка записей в SharedPreferences
     * @param context контекст
     * @param recordsList список записей
     */
    public static void saveRecordsList(Context context, ArrayList<Record> recordsList) {
        SharedPreferences prefs = context.getSharedPreferences("diaryPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(recordsList);
        editor.putString("recordsList", json);
        editor.apply();
    }

    /**
     * Метод для загрузки списка записей из SharedPreferences
     * @param context контекст
     */
    public static ArrayList<Record> loadRecordsList(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("diaryPrefs", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("recordsList", null);
        Type type = new TypeToken<ArrayList<Record>>() {}.getType();
        ArrayList<Record> recordsList = gson.fromJson(json, type);

        if (recordsList == null) {
            recordsList = new ArrayList<Record>();
        }
        return recordsList;
    }

    /**
     * Метод для сохранения записки с главного экрана
     * @param context контекст
     * @param editText элемент, текст которого сохранения
     */
    public static void saveEditTextNote (Context context, EditText editText) {
        SharedPreferences prefs = context.getSharedPreferences("notePref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String note = editText.getText().toString();
        editor.putString("note", note);
        editor.apply();
    }

    /**
     * Метод для загрузки записки с главного экрана
     * @param context контекст
     * @param editText элемент, в который загружается записка
     */
    public static void loadEditTextNote (Context context, EditText editText) {
        SharedPreferences prefs = context.getSharedPreferences("notePref", Context.MODE_PRIVATE);
        String note = prefs.getString("note", "");
        editText.setText(note);
    }
}
