package com.translate.service;

/**
 * Created by Administrator on 2017/12/24.
 */
public interface WxUserService {
  /**
   * ++++++++++++++++++++微信小程序后台服务接口++++++++++++++++++++
   */
  /**
   * 利用客户端（小程序）获得的当前登录微信用户的登录凭证(wxCode)返回token
   *
   * @param wxCode 当前登录微信用户的登录凭证
   * @return tokenId
   */
  String getToken(String wxCode);
}