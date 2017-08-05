package com.zjx.controller;


import com.zjx.constants.Constants;
import com.zjx.constants.Result;
import com.zjx.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
public class SwaggerController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "增加用户")
    public Result<UserVo> add(@ApiParam(name = "token", value = "token",required = true) @RequestParam(name = "token", required = true) String token,
                              @ApiParam(name = "userName",value = "用户昵称",required = true)@RequestParam(name = "userName",required = true)String userName,
                              @ApiParam(name = "mobile",value = "手机",required = true)@RequestParam(name = "mobile",required = true)String mobile,
                              @ApiParam(required = true, name = "email", value = "邮箱") @RequestParam(name = "email", required = true) String email ) {

        return new Result<UserVo>(Constants.SUCCESS,Constants.MSG_SUCCESS,new UserVo());
    }

    @com.wordnik.swagger.annotations.ApiOperation(value="Get user with id",notes="requires the id of user")
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public UserVo getUserById(@PathVariable String name){
        UserVo user=new UserVo();
        user.setUserName("hello world");
        return user;
    }
}
