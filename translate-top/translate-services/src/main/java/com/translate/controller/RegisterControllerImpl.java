package com.translate.controller;

import com.translate.constants.MailConsts;
import com.translate.service.RegisterService;
import com.translate.support.MailQueue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.mail.SimpleMailMessage;
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
public class RegisterControllerImpl implements RegisterService {

  @Override
  @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
  @ApiOperation(value = "发送邮件", notes = "发送邮件")
  public boolean sendMail(
      @ApiParam(name = "receiver", value = "接收者", required = true) @RequestParam(name = "receiver", required = true) String receiver) {

    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setFrom(MailConsts.SENDER);
    mail.setTo(receiver);
    mail.setSubject("[翻译帮]这是您的注册码，打死都不要告诉其他人哦！");
    mail.setText(message);

    try {
      MailQueue.getMailQueueInstance().produce(mail);
      return true;
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return false;
  }

}
