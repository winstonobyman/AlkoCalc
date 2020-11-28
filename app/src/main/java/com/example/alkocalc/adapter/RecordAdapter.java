package com.example.alkocalc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.alkocalc.R;
import com.example.alkocalc.entity.Record;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RecordAdapter extends ArrayAdapter<Record> {

    /**
     * Кастомный адаптер для ListView, отображает дату и число выпитого
     */

    private int resourceLayout;
    private Context mContext;

    public RecordAdapter(Context context, int resource, List<Record> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Record p = getItem(position);

        if (p != null) {
            TextView tt2 = (TextView) v.findViewById(R.id.recordDate);
            TextView tt3 = (TextView) v.findViewById(R.id.recordText);

            if (tt2 != null) {
                Calendar rawDate = p.getRecordDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
                String strDate = sdf.format(rawDate.getTime());
                tt2.setText(strDate);
            }

            if (tt3 != null) {
                tt3.setText(p.getRecordText());
            }
        }

        return v;
    }

}

