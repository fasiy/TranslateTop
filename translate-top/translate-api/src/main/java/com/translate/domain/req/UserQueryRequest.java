package com.translate.domain.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/8/13.
 */
@ToString
public class UserQueryRequest {

  @Setter
  @Getter
  private String username;

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

  /**
   * 是否开启模糊查询
   */
  @Setter
  @Getter
  private boolean fuzzyQuery;
}