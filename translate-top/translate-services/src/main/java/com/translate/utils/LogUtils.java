package com.translate.utils;


import java.text.MessageFormat;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/8/9.
 */
public class LogUtils {

  /**
   * 封装日志打印
   *
   * @param logger 日志类
   * @param formatMsg 日志模版
   * @param args 变量
   */
  public static void info(Logger logger, String formatMsg, Object... args) {

    String msg = MessageFormat.format(formatMsg, args);
    logger.info(msg);
  }
}