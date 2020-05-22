package com.example.alkocalc;

import android.content.SharedPreferences;

import java.util.Objects;

public class TimeCalculator {

    private double percent;
    private double volume;
    private int weight;
    private boolean male;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeCalculator that = (TimeCalculator) o;
        return Double.compare(that.percent, percent) == 0 &&
                Double.compare(that.volume, volume) == 0 &&
                weight == that.weight &&
                male == that.male;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent, volume, weight, male);
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public TimeCalculator() {

    }

    public TimeCalculator(double percent, double volume, int weight, boolean male) {
        this.percent = percent;
        this.volume = volume;
        this.weight = weight;
        this.male = male;
    }

    public double getTime() {
        double c = male ? 1 : 1.2;
        return 0; //TODO calculation formula
    }
}
