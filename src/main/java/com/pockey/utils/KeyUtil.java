package com.pockey.utils;

import java.util.Random;

/**
 * Created by LIQing
 * 2017/10/29 17:03
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        // 生成6位随机数
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
