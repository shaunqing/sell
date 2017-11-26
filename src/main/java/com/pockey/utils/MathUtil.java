package com.pockey.utils;

/**
 * Created by LIQing
 * 2017/11/26 21:43
 */
public class MathUtil {

    private static final Double Money_Range = 0.01;

    /**
     * 比较2个金额是否相等
     * 防止由于精度丢失导致的不相等问题
     *
     * @param d1
     * @param d2
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < Money_Range) {
            return true;
        } else {
            return false;
        }
    }
}
