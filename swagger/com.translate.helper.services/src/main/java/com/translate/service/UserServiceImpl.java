package com.translate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.domain.UserVo;
import com.translate.mapper.UserMapper;
import com.translate.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserVo getUserInfo(){
        UserVo user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

}
