package com.translate.controller;

import com.translate.constants.Result;
import com.translate.domain.UserVo;

/**
 * Created by ljh on 2017/6/29.
 * @author zhaojiaxing
 * @version V2.0 Copyright (c)2016 tyj-版权所有
 */
public interface SwaggerController {
	Result<UserVo> add(String token, String userName, String mobile, String email);
	UserVo getUserById(String name);
}
