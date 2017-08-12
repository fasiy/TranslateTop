package com.translate.service;

import com.translate.domain.BasicUserInfo;
import com.translate.domain.req.UserQueryRequest;

/**
 * Created by Administrator on 2017/8/13.
 */
public interface UserQueryService {

  /**
   * 查询用户信息
   */
  BasicUserInfo queryUser(UserQueryRequest request);
}