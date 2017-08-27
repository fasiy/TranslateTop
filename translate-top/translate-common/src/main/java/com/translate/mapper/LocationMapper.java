package com.translate.mapper;

import com.translate.domain.model.City;
import com.translate.domain.model.Province;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public interface LocationMapper {

  List<Province> queryAllProvinces();

  List<City> queryAllCitiesInProvince(String provinceId);
}