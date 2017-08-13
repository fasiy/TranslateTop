package com.translate.service;

import com.translate.domain.BasicUserInfo;
import javax.validation.constraints.Pattern;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface RegisterService {

  /**
   * 在注册之前，输入[邮箱号|手机号]验证当前[邮箱号|手机号]有无注册过
   * 若有，查询[邮箱号|手机号]绑定的账号
   * 若没有，注册新用户
   */
  boolean fetchVerificationCode(
      @Pattern(regexp = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\\\.[a-zA-Z]+)+") String receiver);

  /**
   * 用户收到验证码之后，与服务器保存的验证码进行匹配
   */
  boolean checkVerificationCode(String email, String verificationCode);

  /**
   * 当验证码通过校验之后，获取当前[邮箱号|手机号]所绑定的账号信息
   */
  BasicUserInfo queryBindingUserInfo(String email);
}