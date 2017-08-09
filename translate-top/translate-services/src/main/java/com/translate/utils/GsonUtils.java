package com.translate.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/8/9.
 */
public class GsonUtils {

  private static Gson gson = new GsonBuilder().create();

  public static String toJson(Object obj) {
    return null == obj ? StringUtils.EMPTY : gson.toJson(obj);
  }

  public static <T> T fromJson(String json, Class<T> clazz) {
    return StringUtils.isBlank(json) ? null : gson.fromJson(json, clazz);
  }

  public static <T> T fromJson(String json, TypeToken<T> token) {
    return StringUtils.isBlank(json) ? null : (T) gson.fromJson(json, token.getType());
  }
}