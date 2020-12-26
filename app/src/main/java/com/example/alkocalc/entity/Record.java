package com.example.alkocalc.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * Класс записи - поле даты и записи, сколько было выпито
 */

public class Record implements Serializable {

    /**
     * Дата и текст для записи
     */
    private Calendar recordDate;
    private String recordText;

    public Record(Calendar recordDate, String recordText) {
        this.recordText = recordText;
        this.recordDate = recordDate;
    }


    public String getRecordText() {
        return recordText;
    }

    public Calendar getRecordDate() {
        return recordDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return  Objects.equals(recordDate, record.recordDate) &&
                Objects.equals(recordText, record.recordText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordDate, recordText);
    }
}
