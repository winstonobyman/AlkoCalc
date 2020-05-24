package com.example.alkocalc.calculations;

public class FormulaUtils {

    /**
     *  Класс с математическими формулами для вычисления
     * */

    public static int[] getHoursMinutes(float hours) {  // возвращает 0 - часы, 1 - минуты
        int[] result = new int[2];
        result[0] = (int)hours;
        result[1] = Math.round((hours % 1) * 60);
        return result;
    }

    public static float round(float value, int places) {
        float scale = (float)Math.pow(10, places);
        return (float)(Math.round(value * scale) / scale);
    }

    public static float getA(float d, // коэффициент резорбции 0.7 при аолном желудке, 0.9 при пустом
                              int volume, // объём в мл
                              float percent) { // крепость в процентах
        return (float) (d * 0.78 * volume * percent);
    }

    public static float getC(float a, // чистый этанол в крови, по функции выше
                              float m, // масса тела
                              float r) { // коэф. распределения Видмарка - 0.7 мужчины, 0.6 - женщины
        return (float)(a/(m * r));
    }

    public static float getSoberTime(float c, // концентрация промилле в крови, формула выше
                                      float g) { // половой коэффициент - 1 мужчины, 1.2 женщины
        // вместо 0.15 можно и 0.1 и 0.2 (V)
        return (float)(((c/0.15) * g));
    }
}
