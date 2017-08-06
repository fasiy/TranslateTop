package com.translate.controller;

import com.translate.constants.MailConsts;
import com.translate.domain.Mail;
import com.translate.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/6.
 */
@RestController
@RequestMapping("/register")
@Api(description = "用户注册接口文档")
public class RegisterController
{
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ApiOperation(value = "发送邮件", notes = "发送邮件")
    public boolean sendMail(@ApiParam(name = "receiver", value = "接收者", required = true) @RequestParam(name = "receiver", required = true) String receiver,
                            @ApiParam(name = "subject", value = "邮件主题", required = true) @RequestParam(name = "subject", required = true) String subject,
                            @ApiParam(name = "message", value = "邮件内容", required = true) @RequestParam(name = "message", required = true) String message)
    {
        Mail mail = new Mail();

        mail.setHostName(MailConsts.HOST_NAME);
        mail.setUsername(MailConsts.USERNAME);
        mail.setPassword(MailConsts.PASSWORD);
        mail.setSender(MailConsts.SENDER);
        mail.setReceiver(receiver);
        mail.setSubject(subject);
        mail.setMessage(message);

        return mailService.sendEmail(mail);
    }
}
