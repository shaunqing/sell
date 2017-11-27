package com.pockey.utils;

import com.pockey.enums.CodeEnum;

/**
 * Created by LIQing
 * 2017/11/27 21:14
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
