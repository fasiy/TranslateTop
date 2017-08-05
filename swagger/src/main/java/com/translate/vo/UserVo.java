package com.translate.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by translate on 2017/6/29.
 *
 * @author zhaojiaxing
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 */
@ApiModel(value = "用户信息")
public class UserVo {
    @ApiModelProperty(value = "用户id", required = true)
    private long userId;
    @ApiModelProperty(value = "昵称", required = true)
    private String userName;

    @ApiModelProperty(value = "年龄", required = true)
    private Integer userAge;

    @ApiModelProperty(value = "用户密码", required = true)
    private String userPassword;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
