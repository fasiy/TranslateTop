package com.translate.service;

import com.translate.domain.BasicUserInfo;
import com.translate.domain.req.UserQueryRequest;
import com.translate.mapper.BasicUserMapper;
import com.translate.model.Flag;
import com.translate.model.Operation;
import com.translate.utils.GsonUtils;
import com.translate.utils.LogUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/13.
 */
@Service
public class DefaultUserQueryService implements UserQueryService {

  private Logger logger = Logger.getLogger(DefaultUserQueryService.class);

  @Autowired
  private BasicUserMapper basicUserMapper;

  @Override
  public BasicUserInfo queryUser(UserQueryRequest request) {

    LogUtils.info(logger, "queryUser", Operation.ENTRY, Flag.REQUEST, GsonUtils.toJson(request));

    BasicUserInfo basicUserInfo = basicUserMapper.queryBasicUserInfo(request);

    LogUtils
        .info(logger, "queryUser", Operation.EXIT, Flag.RESPONSE, GsonUtils.toJson(basicUserInfo));

    return basicUserInfo;
  }
}