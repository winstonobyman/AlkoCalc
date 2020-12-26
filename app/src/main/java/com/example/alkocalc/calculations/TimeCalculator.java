package com.example.alkocalc.calculations;

import com.example.alkocalc.utils.FormulaUtils;

/**
 * Служебный класс для вычислений времени отрезвления и дозы напитка
 */
public class TimeCalculator {

    /**
     * Принимает разные параметры для двух конструкторов
     * Затем можно получить характеристики от объекта
     */

    // принимает
    private float percent;
    private int volume;
    private float weight;
    private boolean male;
    private boolean eaten;

    // вычисляет

    // кожффициенты
    float d;           // коэффициент резорбции 0.7 при аолном желудке, 0.9 при пустом
    float r;           // коэф. распределения Видмарка - 0.7 мужчины, 0.6 - женщины
    float g;           // половой коэффициент - 1 мужчины, 1.2 женщины

    float a;           // чистый этанол в крови в граммах
    float c;           // концентрация промилле в крови
    float soberTime;   // время отрезвления в часах

    /**
     * Конструктор для вычисления времени
     * @param percent крепость напитка
     * @param volume объем выпитого
     * @param eaten закусывал ли человек
     * @param weight вес человека
     * @param male пол человека
     */
    public TimeCalculator(float percent, int volume, boolean eaten, float weight, boolean male) {
        this.percent = percent;
        this.volume = volume;
        this.weight = weight;
        this.male = male;
        this.eaten = eaten;

        this.d = (float)(eaten ? 0.7 : 0.9);
        this.r = (float)(male ? 0.7 : 0.6);
        this.g = (float)(male ? 1 : 1.2);

        this.a = FormulaUtils.getA(d, volume, percent);
        this.c = FormulaUtils.getC(a, weight, r);
        this.soberTime = FormulaUtils.getSoberTime(this.c, this.g);
    }

    /**
     * Конструктор для получения желаемой степени опьянения
     * @param c параметр с
     * @param weight вес
     * @param male пол
     * @param eaten закусывал ли
     * @param percent крепость напитка
     */
    public TimeCalculator(float c, float weight, boolean male,  boolean eaten, float percent) {
        this.percent = percent;
        this.c = c;
        this.weight = weight;
        this.male = male;
        this.eaten = eaten;

        this.r = (float)(male ? 0.7 : 0.6);
        this.d = (float)(eaten ? 0.7 : 0.9);
        this.g = (float)(male ? 1 : 1.2);

        this.soberTime = FormulaUtils.getSoberTime(this.c, this.g);
        this.volume = (int)Math.round((this.c * this.weight * this.r)/(this.d * 0.78 * this.percent));
    }

    public float getA() {
        return a;
    }

    public float getC() {
        return c;
    }

    public float getSoberTime() {
        return soberTime;
    }

    public float getPercent() {
        return percent;
    }

    public int getVolume() {
        return volume;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isEaten() {
        return eaten;
    }

    public float getD() {
        return d;
    }

    public float getR() {
        return r;
    }

    public float getG() {
        return g;
    }
}
