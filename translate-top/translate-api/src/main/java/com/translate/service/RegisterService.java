package com.translate.service;

import com.translate.domain.BasicUserInfo;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface RegisterService {

  /**
   * 在注册之前，输入[邮箱号|手机号]验证当前[邮箱号|手机号]有无注册过
   * 若有，查询[邮箱号|手机号]绑定的账号
   * 若没有，注册新用户
   */
  boolean fetchVerificationCode(String receiver);

  /**
   * 用户收到验证码之后，与服务器保存的验证码进行匹配
   */
  String checkVerificationCode(String email, String verificationCode);

  /**
   * 当验证码通过校验之后，获取当前[邮箱号|手机号]所绑定的账号信息
   */
  BasicUserInfo queryBindingUserInfo(String email);

  /**
   * 注册新用户
   */
  boolean register(BasicUserInfo userInfo,String emailToken);

  /**
   * 登录
   */
  boolean login(String email, String password);
}