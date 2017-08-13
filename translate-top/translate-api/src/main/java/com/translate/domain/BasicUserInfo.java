package com.translate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/8/13.
 */
@ToString
public class BasicUserInfo {

  @Setter
  @Getter
  private String id;

  @Setter
  @Getter
  private String username;

  @Setter
  @Getter
  private String password;

  @Setter
  @Getter
  private String mobile;

  @Setter
  @Getter
  private String email;

  @Setter
  @Getter
  private String province;

  @Setter
  @Getter
  private String city;

  @Setter
  @Getter
  private String workPlace;
}