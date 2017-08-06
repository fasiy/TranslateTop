package com.translate.service;

import com.translate.mapper.UserMapper;
import com.translate.domain.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserVo getUserInfo(){
        UserVo user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

}
