package com.translate.controller.demo;

import com.translate.domain.demo.UserInfo;
import com.translate.mapper.UserMapper;
import com.translate.service.demo.HelloService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户注册接口文档")
public class HelloControllerImpl implements HelloService {
	@Autowired
	private UserMapper userMapper;

	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		UserInfo userVo = userMapper.findUserInfo();
		return userVo.getUserName();
	}
}
