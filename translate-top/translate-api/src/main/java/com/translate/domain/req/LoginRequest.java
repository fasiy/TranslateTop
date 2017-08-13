package com.translate.domain.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/8/13.
 */
@ToString
public class LoginRequest {

  @Setter
  @Getter
  private String email;

  @Setter
  @Getter
  private String password;
}