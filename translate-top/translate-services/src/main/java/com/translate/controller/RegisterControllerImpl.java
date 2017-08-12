package com.translate.controller;

import com.translate.constants.MailConsts;
import com.translate.domain.BasicUserInfo;
import com.translate.domain.req.UserQueryRequest;
import com.translate.service.RegisterService;
import com.translate.service.UserQueryService;
import com.translate.support.MailQueue;
import com.translate.utils.ValidateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Random;
import javax.validation.Validation;
import javax.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.ValidationUtils;
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

  @Autowired
  private EhCacheCacheManager appEhCacheCacheManager;

  @Autowired
  private UserQueryService userQueryService;

  /**
   * (1) 先查找缓存里面对应key为当前receiver有没有value。如果有value，直接发送value给指定的receiver；
   * (2) 如果没有，那么生成6位随机验证码发给receiver
   */
  @Override
  @RequestMapping(value = "/fetchVerificationCode", method = RequestMethod.POST)
  @ApiOperation(value = "获取验证码", notes = "获取验证码")
  public boolean fetchVerificationCode(
      @ApiParam(name = "receiver", value = "接收者", required = true) @RequestParam(name = "receiver", required = true) String receiver) {

    String verificationCode = StringUtils.EMPTY;
    Cache cache = appEhCacheCacheManager.getCache("verificationCode");
    ValueWrapper valueWrapper = cache.get(receiver);

    if (null != valueWrapper) {
      verificationCode = (String) valueWrapper.get();
      System.out.println("缓存中拿到的：" + verificationCode);
    } else {
      //生成随机的6位数字验证码
      Random random = new Random(System.currentTimeMillis());
      for (int i = 0; i < 6; i++) {
        verificationCode += random.nextInt(10);
      }
      System.out.println("随机生成的：" + verificationCode);
      //将验证码放入缓存
      cache.put(receiver, verificationCode);
    }

    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setFrom(MailConsts.SENDER);
    mail.setTo(receiver);
    mail.setSubject("[翻译帮]这是您的注册码，打死都不要告诉其他人哦！");

    mail.setText(String.valueOf(verificationCode));

    try {
      MailQueue.getMailQueueInstance().produce(mail);
      return true;
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  @RequestMapping(value = "/checkVerificationCode", method = RequestMethod.POST)
  @ApiOperation(value = "校验验证码", notes = "校验验证码")
  public boolean checkVerificationCode(
      @ApiParam(name = "email", value = "邮箱账号", required = true) @RequestParam(name = "email", required = true) String email,
      @ApiParam(name = "verificationCode", value = "验证码", required = true) @RequestParam(name = "verificationCode", required = true) String verificationCode) {

    String serverVerificationCode = StringUtils.EMPTY;
    Cache cache = appEhCacheCacheManager.getCache("verificationCode");
    ValueWrapper valueWrapper = cache.get(email);

    if (null != valueWrapper) {
      serverVerificationCode = (String) valueWrapper.get();
      System.out.println("服务器中缓存的验证码：" + verificationCode);

      //服务器中缓存的验证码与客户端传输过来的验证码一致，通过验证
      if (StringUtils.equals(serverVerificationCode, verificationCode)) {
        System.out.println("客户端通过验证！");
        return true;
      }
    }
    return false;
  }

  @Override
  @RequestMapping(value = "/queryBindingUserInfo", method = RequestMethod.POST)
  @ApiOperation(value = "获取绑定邮箱的账号信息", notes = "获取绑定邮箱的账号")
  public BasicUserInfo queryBindingUserInfo(
      @ApiParam(name = "email", value = "邮箱账号", required = true) @RequestParam(name = "email", required = true) String email) {

    UserQueryRequest request = new UserQueryRequest();
    request.setEmail(email);

    BasicUserInfo basicUserInfo = userQueryService.queryUser(request);
    return basicUserInfo;
  }
}