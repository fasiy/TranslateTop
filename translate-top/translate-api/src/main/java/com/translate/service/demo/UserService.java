package com.translate.service.demo;

import com.translate.domain.demo.UserInfo;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

  UserInfo getUserInfo();

}
