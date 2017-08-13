package com.translate.service;

import com.translate.domain.BasicUserInfo;
import com.translate.domain.req.LoginRequest;
import com.translate.domain.req.UserQueryRequest;
import com.translate.domain.rsp.UserQueryResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/8/13.
 */
public interface UserService {

  /**
   * 查询用户信息
   */
  UserQueryResponse queryUser(UserQueryRequest request);

  /**
   * 用户注册
   */
  boolean register(BasicUserInfo userInfo);

  /**
   * 用户登录
   */
  boolean login(LoginRequest request);
}