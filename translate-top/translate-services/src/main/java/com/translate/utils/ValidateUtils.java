package com.translate.utils;

import com.translate.support.MailConsumer;
import java.util.Iterator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/8/12.
 */
public class ValidateUtils {

  private static Logger logger = Logger.getLogger(ValidateUtils.class);

  /**
   * 校验参数
   */
  public static void validate(Object obj) {

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
    Iterator<ConstraintViolation<Object>> iter = constraintViolations
        .iterator();

    StringBuffer buffer = new StringBuffer();

    while (iter.hasNext()) {
      String message = iter.next().getMessage();
      buffer.append(message);
    }
    String errorMsg = buffer.toString();

    LogUtils.info(logger, "validate", Operation.EXCEPTION, Flag.ERROR, errorMsg);
  }
}