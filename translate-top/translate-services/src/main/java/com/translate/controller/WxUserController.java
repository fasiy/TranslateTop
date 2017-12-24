package com.translate.controller;

import com.translate.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/24.
 */
@RestController
@RequestMapping("/wxUser")
@Api(description = "小程序用户接口信息文档")
public class WxUserController {

  @Autowired
  private WxUserService wxUserService;

  @RequestMapping(value = "/getToken", method = RequestMethod.GET)
  @ApiOperation(value = "获取token", notes = "获取token")
  public String getToken(
      @ApiParam(name = "wxCode", value = "当前登录微信用户的登录凭证", required = true) @RequestParam(name = "wxCode", required = true) String wxCode) {
    return wxUserService.getToken(wxCode);
  }
}