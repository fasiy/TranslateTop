package com.translate.exception;

/**
 * Created by Administrator on 2017/8/13.
 */
public class TranslateException extends RuntimeException {

  public TranslateException() {
  }

  public TranslateException(String message) {
    super(message);
  }

  public TranslateException(String message, Throwable cause) {
    super(message, cause);
  }

  public TranslateException(Throwable cause) {
    super(cause);
  }

  public TranslateException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}