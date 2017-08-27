package com.translate.controller;

import com.translate.domain.model.City;
import com.translate.domain.model.Province;
import com.translate.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/23.
 */
@RestController
@RequestMapping("/location")
@Api(description = "位置信息接口文档")
public class LocationController {

  @Autowired
  private LocationService locationService;

  @RequestMapping(value = "/provinces", method = RequestMethod.GET)
  @ApiOperation(value = "获取所有省份", notes = "获取所有省份")
  public List<Province> queryAllProvinces() {

    List<Province> provinces = locationService.queryAllProvinces();

    return provinces;
  }

  @RequestMapping(value = "/cities", method = RequestMethod.GET)
  @ApiOperation(value = "获取省份下的所有城市", notes = "获取省份下的所有城市")
  public List<City> queryAllCitiesInProvince(
      @ApiParam(name = "provinceId", value = "省份id", required = true)
      @RequestParam(name = "provinceId", required = true) String provinceId) {

    List<City> cities = locationService.queryAllCitiesInProvince(provinceId);

    return cities;
  }
}
