package com.translate.controller.demo;


import com.translate.service.demo.SwaggerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.translate.constants.Constants;
import com.translate.constants.Result;
import com.translate.domain.UserInfo;

/**
 * Created by ljh on 2017/6/29.
 *
 * @author zhaojiaxing
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户相关接口文档")
public class SwaggerControllerImpl implements SwaggerService {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "增加用户")
    public Result<UserInfo> add(@ApiParam(name = "token", value = "token",required = true) @RequestParam(name = "token", required = true) String token,
                              @ApiParam(name = "userName",value = "用户昵称",required = true)@RequestParam(name = "userName",required = true)String userName,
                              @ApiParam(name = "mobile",value = "手机",required = true)@RequestParam(name = "mobile",required = true)String mobile,
                              @ApiParam(required = true, name = "email", value = "邮箱") @RequestParam(name = "email", required = true) String email ) {

        return new Result<UserInfo>(Constants.SUCCESS,Constants.MSG_SUCCESS,new UserInfo());
    }

    @com.wordnik.swagger.annotations.ApiOperation(value="Get user with id",notes="requires the id of user")
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public UserInfo getUserById(@PathVariable String name){
        UserInfo user=new UserInfo();
        user.setUserName("hello world");
        return user;
    }
}
