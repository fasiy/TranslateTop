package com.translate.controller;

import com.translate.domain.UserVo;
import com.translate.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户注册接口文档")
public class HelloControllerImpl implements HelloController {
	@Autowired
	private UserMapper userMapper;

	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		UserVo userVo = userMapper.findUserInfo();
		return userVo.getUserName();
	}
}
