package com.translate.service;

import com.translate.service.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.domain.UserInfo;
import com.translate.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserInfo getUserInfo(){
        UserInfo user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

}
