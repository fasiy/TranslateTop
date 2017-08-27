package com.translate.service;

import com.translate.domain.model.City;
import com.translate.domain.model.Province;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public interface LocationService {

  /**
   * 查询所有的省份
   */
  List<Province> queryAllProvinces();

  /**
   * 查询省份下的所有城市
   */
  List<City> queryAllCitiesInProvince(String provinceId);
}