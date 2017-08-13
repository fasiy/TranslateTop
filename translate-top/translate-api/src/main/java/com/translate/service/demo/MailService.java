package com.translate.service.demo;

import com.translate.domain.Mail;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface MailService {

  boolean sendEmail(Mail mail);
}