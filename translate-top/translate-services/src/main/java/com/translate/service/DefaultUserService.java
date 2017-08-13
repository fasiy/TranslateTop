package com.translate.service;

import com.translate.domain.BasicUserInfo;
import com.translate.domain.req.LoginRequest;
import com.translate.domain.req.UserQueryRequest;
import com.translate.domain.rsp.UserQueryResponse;
import com.translate.exception.TranslateException;
import com.translate.mapper.BasicUserMapper;
import com.translate.model.Flag;
import com.translate.model.Operation;
import com.translate.utils.GsonUtils;
import com.translate.utils.LogUtils;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/13.
 */
@Service
public class DefaultUserService implements UserService {

  private Logger logger = Logger.getLogger(DefaultUserService.class);

  @Autowired
  private BasicUserMapper basicUserMapper;

  @Override
  public UserQueryResponse queryUser(UserQueryRequest request) {

    LogUtils.info(logger, "queryUser", Operation.ENTRY, Flag.REQUEST, GsonUtils.toJson(request));

    List<BasicUserInfo> basicUserInfos = basicUserMapper.queryBasicUserInfos(request);
    int count = basicUserMapper.queryBasicUserInfosCount(request);

    UserQueryResponse response = new UserQueryResponse();
    response.setTotal(count);
    response.setUserInfos(basicUserInfos);

    LogUtils
        .info(logger, "queryUser", Operation.EXIT, Flag.RESPONSE, GsonUtils.toJson(response));

    return response;
  }

  @Override
  public boolean register(BasicUserInfo userInfo) {

    LogUtils.info(logger, "register", Operation.ENTRY, Flag.REQUEST, GsonUtils.toJson(userInfo));

    //检查当前邮箱号和手机号是否被注册过了，如果注册过了，那么本次注册失败
    checkIsExist(userInfo);

    //生成随机的用户id
    String userId = UUID.randomUUID().toString();
    logger.info("generate userId = " + userId);

    userInfo.setId(userId);
    basicUserMapper.registerUser(userInfo);

    LogUtils
        .info(logger, "register", Operation.EXIT, Flag.RESPONSE, GsonUtils.toJson(true));

    return true;
  }

  @Override
  public boolean login(LoginRequest request) {

    LogUtils.info(logger, "login", Operation.ENTRY, Flag.REQUEST, GsonUtils.toJson(request));
    //参数检验
    String email = request.getEmail();
    String password = request.getPassword();

    boolean loginStatus = false;
    if (!StringUtils.isBlank(email) && !StringUtils.isBlank(password)) {
      BasicUserInfo basicUserInfo = basicUserMapper.loginUser(request);
      loginStatus = null != basicUserInfo;
    }
    LogUtils.info(logger, "login", Operation.EXIT, Flag.RESPONSE, GsonUtils.toJson(loginStatus));

    return loginStatus;
  }

  /**
   * 检查当前邮箱号和手机号是否被注册过了，如果注册过了，那么本次注册失败
   */
  private void checkIsExist(BasicUserInfo userInfo) {
    //先校验库中是否已经存在userInfo.email或者userInfo.mobile的记录
    UserQueryRequest request = new UserQueryRequest();
    request.setEmail(userInfo.getEmail());

    //如果该邮箱号已经被注册，那么本次注册失败
    UserQueryResponse response = queryUser(request);
    if (0 != response.getTotal()) {
      String errMsg = "邮箱号已经被注册！";

      LogUtils.info(logger, "register", Operation.EXCEPTION, Flag.ERROR, errMsg);
      throw new TranslateException(errMsg);
    }

    request = new UserQueryRequest();
    request.setMobile(userInfo.getMobile());

    //如果该手机号已经被注册，那么本次注册失败
    response = queryUser(request);
    if (0 != response.getTotal()) {
      String errMsg = "手机号已经被注册！";

      LogUtils.info(logger, "register", Operation.EXCEPTION, Flag.ERROR, errMsg);
      throw new TranslateException(errMsg);
    }
  }
}