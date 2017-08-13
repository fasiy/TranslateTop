package com.translate.service;

import com.translate.model.Flag;
import com.translate.utils.GsonUtils;
import com.translate.utils.LogUtils;
import com.translate.model.Operation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/9.
 */
@Service
public class DefaultMailService implements IMailService {

  private Logger logger = Logger.getLogger(DefaultMailService.class);

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public boolean sendSimpleMail(SimpleMailMessage simpleMailMessage) {

    LogUtils.info(logger, "sendSimpleMail", Operation.ENTRY, Flag.REQUEST,
        GsonUtils.toJson(simpleMailMessage));

    try {
      javaMailSender.send(simpleMailMessage);
      boolean response = true;

      LogUtils.info(logger, "sendSimpleMail", Operation.EXIT, Flag.RESPONSE,
          response);

      return response;
    } catch (MailException e) {
      LogUtils.info(logger, "sendSimpleMail", Operation.EXCEPTION, Flag.ERROR,
          e);
      throw e;
    }
  }
}