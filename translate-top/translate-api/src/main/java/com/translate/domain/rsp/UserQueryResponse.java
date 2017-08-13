package com.translate.domain.rsp;

import com.translate.domain.BasicUserInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/8/13.
 */
@ToString
public class UserQueryResponse {

  @Getter
  @Setter
  private int total;

  @Getter
  @Setter
  private List<BasicUserInfo> userInfos;
}
