package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alkocalc.utils.DiaryUtils;
import com.example.alkocalc.entity.Record;
import com.example.alkocalc.adapter.RecordAdapter;

import java.util.ArrayList;

/**
 * Класс экрана дневника
 */
public class DateDiary extends AppCompatActivity {

    ArrayList<Record> recordsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_diary);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Для удаления зажмите запись", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.show();


        recordsList = DiaryUtils.loadRecordsList(this);
        ListView lvDiary = findViewById(R.id.listViewTest);
        final RecordAdapter customAdapter = new RecordAdapter(this, R.layout.itemlistrow, recordsList);
        lvDiary.setAdapter(customAdapter);

        lvDiary.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Record delRecord = customAdapter.getItem(i);
                        customAdapter.remove(delRecord);
                        recordsList.remove(delRecord);
                        customAdapter.notifyDataSetChanged();

                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Запись удалена!", Toast.LENGTH_SHORT);
                        toast.show();
                        return true;
                    }
                }
        );


    }


    public void onBackClick(View view) {
        DiaryUtils.saveRecordsList(this, recordsList);
        Intent intent = new Intent(this, ChooseFunction.class);
        startActivity(intent);
    }
}
