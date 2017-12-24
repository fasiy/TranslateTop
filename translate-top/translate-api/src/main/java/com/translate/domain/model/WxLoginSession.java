package com.translate.domain.model;

import lombok.Data;

/**
 * Created by Administrator on 2017/12/24.
 */
@Data
public class WxLoginSession {

  private String tokenId;

  private String errorCode;

  private String errorMsg;
}
