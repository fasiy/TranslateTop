package com.translate.service;

import com.translate.domain.model.City;
import com.translate.domain.model.Province;
import com.translate.mapper.LocationMapper;
import com.translate.model.Flag;
import com.translate.model.Operation;
import com.translate.utils.GsonUtils;
import com.translate.utils.LogUtils;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class DefaultLocationService implements LocationService {

  private Logger logger = Logger.getLogger(DefaultUserService.class);

  @Autowired
  private LocationMapper locationMapper;

  @Override
  public List<Province> queryAllProvinces() {

    LogUtils.info(logger, "queryAllProvinces", Operation.ENTRY, Flag.REQUEST, "");

    List<Province> provinces = locationMapper.queryAllProvinces();

    LogUtils
        .info(logger, "queryAllProvinces", Operation.EXIT, Flag.RESPONSE,
            GsonUtils.toJson(provinces));
    return provinces;
  }

  @Override
  public List<City> queryAllCitiesInProvince(String provinceId) {

    LogUtils.info(logger, "queryAllCitiesInProvince", Operation.ENTRY, Flag.REQUEST, "provinceId");

    List<City> cities = locationMapper.queryAllCitiesInProvince(provinceId);

    LogUtils
        .info(logger, "queryAllCitiesInProvince", Operation.EXIT, Flag.RESPONSE,
            GsonUtils.toJson(cities));

    return cities;
  }
}