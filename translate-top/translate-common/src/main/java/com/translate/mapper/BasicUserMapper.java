package com.translate.mapper;

import com.translate.domain.model.BasicUserInfo;
import com.translate.domain.req.LoginRequest;
import com.translate.domain.req.UserQueryRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/8/13.
 */
public interface BasicUserMapper {

  List<BasicUserInfo> queryBasicUserInfos(UserQueryRequest request);

  int queryBasicUserInfosCount(UserQueryRequest request);

  void registerUser(BasicUserInfo userInfo);

  BasicUserInfo loginUser(LoginRequest request);
}