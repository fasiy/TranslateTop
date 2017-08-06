package com.translate.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.translate.domain.Mail;
import com.translate.service.MailService;

/**
 * Created by Administrator on 2017/8/6.
 */
@Service
public class MailServiceImpl implements MailService
{
    private Logger logger = Logger.getLogger(MailService.class);


    @Override
    public boolean sendEmail(Mail mail) {

        HtmlEmail htmlEmail = new HtmlEmail();

        try
        {
            htmlEmail.setHostName(mail.getHostName());
            htmlEmail.setCharset("UTF-8");
            htmlEmail.addTo(mail.getReceiver());
            htmlEmail.setFrom(mail.getSender());
            htmlEmail.setAuthentication(mail.getUsername(), mail.getPassword());
            htmlEmail.setSubject(mail.getSubject());
            htmlEmail.setMsg(mail.getMessage());

            htmlEmail.send();
            logger.info("发送邮件成功");

        } catch (EmailException e)
        {
            logger.error("发送邮件失败");
            return false;
        }
        return true;
    }
}