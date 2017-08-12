package com.translate.support;

import com.translate.service.IMailService;
import com.translate.model.Flag;
import com.translate.utils.LogUtils;
import com.translate.model.Operation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/9.
 * 消费队列中的邮件
 */
@Service
public class MailConsumer {

  private Logger logger = Logger.getLogger(MailConsumer.class);

  @Autowired
  private IMailService mailService;

  @PostConstruct
  public void start() {

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(new Runnable() {
      @Override
      public void run() {
        while (true) {
          String currThreadName = Thread.currentThread().getName();

          try {
            SimpleMailMessage mail = MailQueue.getMailQueueInstance().consume();
            if (null != mail) {
              boolean status = mailService.sendSimpleMail(mail);
              LogUtils.info(logger, currThreadName, Operation.EXIT, Flag.RESPONSE, status);
            }
          } catch (InterruptedException e) {
            LogUtils
                .info(logger, currThreadName, Operation.EXCEPTION, Flag.ERROR, e);
          }
        }
      }
    });
  }
}