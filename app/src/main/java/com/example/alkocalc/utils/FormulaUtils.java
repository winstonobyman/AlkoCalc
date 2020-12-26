package com.example.alkocalc.utils;

/**
 *  Класс с математическими формулами для вычисления
 * */
public class FormulaUtils {

    /**
     * Перевод часов в часы и минуты
     * @param hours часы
     * @return часы и минуты (в формате int)
     */
    public static int[] getHoursMinutes(float hours) {  // возвращает 0 - часы, 1 - минуты
        int[] result = new int[2];
        result[0] = (int)hours;
        result[1] = Math.round((hours % 1) * 60);
        return result;
    }

    /**
     * Функция для округления float-значений
     * @param value число
     * @param places до какого знака
     * @return округленное число
     */
    public static float round(float value, int places) {
        float scale = (float)Math.pow(10, places);
        return (float)(Math.round(value * scale) / scale);
    }

    /**
     *
     * @param d коэффициент резорбции 0.7 при аолном желудке, 0.9 при пустом
     * @param volume объём в мл
     * @param percent крепость в процентах
     * @return A
     */
    public static float getA(float d, // коэффициент резорбции 0.7 при аолном желудке, 0.9 при пустом
                              int volume, // объём в мл
                              float percent) { // крепость в процентах
        return (float) (d * 0.78 * volume * percent);
    }

    /**
     *
     * @param a чистый этанол в крови
     * @param m масса тела
     * @param r коэф. распределения Видмарка - 0.7 мужчины, 0.6 - женщины
     * @return C
     */
    public static float getC(float a, // чистый этанол в крови, по функции выше
                              float m, // масса тела
                              float r) { // коэф. распределения Видмарка - 0.7 мужчины, 0.6 - женщины
        return (float)(a/(m * r));
    }

    /**
     * Функция для получения времени отрезвления
     * @param c концентрация промилле в крови
     * @param g половой коэффициент - 1 мужчины, 1.2 женщины
     * @return Время отрезвления в часах
     */
    public static float getSoberTime(float c, // концентрация промилле в крови, формула выше
                                      float g) { // половой коэффициент - 1 мужчины, 1.2 женщины
        // вместо 0.15 можно и 0.1 и 0.2 (V)
        return (float)(((c/0.15) * g));
    }
}
