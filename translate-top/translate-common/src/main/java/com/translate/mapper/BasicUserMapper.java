package com.translate.mapper;

import com.translate.domain.BasicUserInfo;
import com.translate.domain.req.UserQueryRequest;

/**
 * Created by Administrator on 2017/8/13.
 */
public interface BasicUserMapper {

  BasicUserInfo queryBasicUserInfo(UserQueryRequest request);
}
