package com.translate.service;

import com.alibaba.fastjson.JSONObject;
import com.translate.constants.WxConstants;
import com.translate.controller.RegisterController;
import com.translate.domain.model.WxLoginSession;
import com.translate.model.Flag;
import com.translate.model.Operation;
import com.translate.model.WxLoginError;
import com.translate.model.WxToken;
import com.translate.utils.GsonUtils;
import com.translate.utils.LogUtils;
import java.util.Random;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

/**
 * Created by Administrator on 2017/12/24.
 */
@Service
public class DefaultWxUserService implements WxUserService {

  private static Logger logger = Logger.getLogger(DefaultWxUserService.class);

  @Autowired
  private RestTemplate restTemplate;

  /**
   * token信息缓存
   */
  @Autowired
  private EhCacheCacheManager appEhCacheCacheManager;

  @Override
  public WxLoginSession getToken(String wxCode) {

    LogUtils.info(logger, "getToken", Operation.ENTRY, Flag.REQUEST, wxCode);

    WxLoginSession wxLoginSessionRsp = new WxLoginSession();
    //wxCode 换取 session_key的微信开发者接口
    /**
     * 参数	必填	说明
     * appid	是	小程序唯一标识
     * secret	是	小程序的 app secret
     * js_code	是	登录时获取的 code
     * grant_type	是	填写为 authorization_code
     */
    String url = "https://api.weixin.qq.com/sns/jscode2session?appid=".concat(WxConstants.APP_ID)
        .concat("&secret=").concat(WxConstants.APP_SECRET).concat("&js_code=")
        .concat(wxCode).concat("&grant_type=authorization_code");

    ResponseEntity<String> respEntity = restTemplate.getForEntity(url, String.class);
    if (HttpStatus.OK == respEntity.getStatusCode()) {
      /**
       * 参数	说明
       * openid	用户唯一标识
       * session_key	会话密钥
       * unionid	用户在开放平台的唯一标识符。本字段在满足一定条件的情况下才返回
       */
      String respBody = respEntity.getBody();
      if (StringUtils.contains(respBody, WxConstants.ERROR_FOUND)) {
        WxLoginError wxLoginError = GsonUtils.fromJson(respBody, WxLoginError.class);

        LogUtils.info(logger, "getToken", Operation.EXCEPTION, Flag.ERROR,
            "get token info from api [https://api.weixin.qq.com/sns/jscode2session] failed.",
            wxLoginError);
        //请求微信Api失败时
        wxLoginSessionRsp.setErrorCode(wxLoginError.getErrcode());
        wxLoginSessionRsp.setErrorMsg(wxLoginError.getErrmsg());
        return wxLoginSessionRsp;
      }

      WxToken wxToken = GsonUtils.fromJson(respBody, WxToken.class);

      //将token信息放缓存
      String tokenId = UUID.randomUUID().toString();
      Cache cache = appEhCacheCacheManager.getCache("tokensCache");
      ValueWrapper valueWrapper = cache.get(tokenId);
      if (null == valueWrapper) {
        //tokenId存入缓存中，以维持用户的登录状态，7200s失效
        cache.put(tokenId, wxToken);
      }

      wxLoginSessionRsp.setTokenId(tokenId);
      LogUtils.info(logger, "getToken", Operation.EXIT, Flag.RESPONSE, wxLoginSessionRsp);
      return wxLoginSessionRsp;
    }
    //访问微信开发者Api异常时(网络问题等)
    wxLoginSessionRsp.setErrorCode(WxConstants.NETWORK_ERROR_CODE);
    wxLoginSessionRsp.setErrorMsg("network error");

    LogUtils.info(logger, "getToken", Operation.EXCEPTION, Flag.ERROR, wxLoginSessionRsp);
    return wxLoginSessionRsp;
  }
}