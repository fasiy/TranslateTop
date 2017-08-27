package com.translate.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/8/23.
 */
@ToString
public class City {

  @Getter
  @Setter
  private String id;

  @Getter
  @Setter
  private String provinceId;


  @Getter
  @Setter
  private String name;
}