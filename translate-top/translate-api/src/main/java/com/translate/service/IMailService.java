package com.translate.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Administrator on 2017/8/9.
 * 使用SpringBoot发送邮件接口
 */
public interface IMailService {

  /**
   * 发送简单邮件
   */
  boolean sendSimpleMail(SimpleMailMessage simpleMailMessage);
}
