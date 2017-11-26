package com.pockey.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by LIQing
 * 2017/11/26 17:47
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
