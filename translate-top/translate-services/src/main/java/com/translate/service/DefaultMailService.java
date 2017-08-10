package com.translate.service;

import com.google.gson.Gson;
import com.translate.utils.GsonUtils;
import com.translate.utils.LogUtils;
import java.text.MessageFormat;
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

    LogUtils.info(logger, "[sendSimpleMail] [ENTRY] [request = {}.]",
        GsonUtils.toJson(simpleMailMessage));

    try {
      javaMailSender.send(simpleMailMessage);
      logger.info("simple mail send success!");
      System.out.println("simple mail send success!");

      boolean response = true;

      LogUtils.info(logger, "[sendSimpleMail] [EXIT] [response = {}.]",
          response);

      return response;
    } catch (MailException e) {
      LogUtils.info(logger, "[sendSimpleMail] [Exception] [error = {}.]", e);
      throw e;
    }
  }
}