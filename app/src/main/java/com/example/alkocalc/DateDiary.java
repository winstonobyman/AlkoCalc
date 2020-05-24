package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.alkocalc.dao.DiaryUtils;
import com.example.alkocalc.entity.Record;
import com.example.alkocalc.entity.RecordAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_diary);
        ArrayList<Record> recordsList = DiaryUtils.loadRecordsList(this);
        ListView lvDiary = findViewById(R.id.listViewTest);
        ListAdapter customAdapter = new RecordAdapter(this, R.layout.itemlistrow, recordsList);
        lvDiary.setAdapter(customAdapter);



    }


    public void onBackClick(View view) {
        Intent intent = new Intent(this, ChooseFunction.class);
        startActivity(intent);
    }
}
