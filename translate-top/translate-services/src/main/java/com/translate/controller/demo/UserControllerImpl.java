package com.translate.controller.demo;

import com.translate.service.demo.UserController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.translate.domain.demo.UserInfo;
import com.translate.service.demo.UserService;


/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserControllerImpl implements UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo() {
        UserInfo user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getUserName());
            logger.info("user.getAge():"+user.getUserName());
        }
        return user;
    }
}
