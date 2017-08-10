package com.translate.service.demo;

import com.translate.constants.Result;
import com.translate.domain.UserInfo;

/**
 * Created by ljh on 2017/6/29.
 *
 * @author zhaojiaxing
 * @version V2.0 Copyright (c)2016 tyj-版权所有
 */
public interface SwaggerService {

  Result<UserInfo> add(String token, String userName, String mobile, String email);

  UserInfo getUserById(String name);
}
