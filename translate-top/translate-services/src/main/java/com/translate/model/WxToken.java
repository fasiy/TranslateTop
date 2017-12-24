package com.translate.model;

import lombok.Data;

/**
 * Created by Administrator on 2017/12/24.
 */
@Data
public class WxToken {

  private String session_key;

  private long expires_in;

  private String openid;
}