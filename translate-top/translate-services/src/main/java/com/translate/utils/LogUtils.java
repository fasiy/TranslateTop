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
  /**
   * 封装日志打印
   *
   * @param logger 日志类
   * @param methodName 方法名
   * @param operation ENTRY或者EXIT
   * @param flag request或者response
   * @param args 参数
   */
  public static void info(Logger logger, String methodName, Operation operation, Flag flag,
      Object... args) {
    StringBuilder builder = new StringBuilder();
    builder.append("[").append(methodName).append("]").append(" ")
        .append("[").append(operation.name()).append("]").append(" ").append("[")
        .append(flag.name())
        .append(" = ")
        .append("{0}.");
    String template = builder.toString();
    String msg = MessageFormat.format(template, args);
    logger.info(msg);
  }
}