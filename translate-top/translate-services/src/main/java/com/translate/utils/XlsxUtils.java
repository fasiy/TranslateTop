package com.translate.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by Administrator on 2017/8/12.
 */
public class XlsxUtils {

  private static final String ZERO_STR = "0";

  /**
   * 根据省份城市编码xlsx生成sql语句
   * INSERT INTO CITY(province_id, city_name, id) VALUES ('110000', '北京市', '110100');
   */
  public static String generateCitySql(String xlsxPath) {
    StringBuilder sb = new StringBuilder();

    //拿到指定路径下的xslx文档对象
    Workbook workbook = getWorkbook(xlsxPath);

    //拿到第一个Sheet
    Sheet sheet = workbook.getSheetAt(0);
    //获取总行数
    int rowNum = sheet.getLastRowNum();
    //从第二行开始遍历，因为第一行是表头
    String lastValue = "0";

    for (int i = 1; i <= rowNum; i++) {
      Row row = sheet.getRow(i);

      //省份编码
      String provinceCode = StringUtils.EMPTY;
      Cell provinceCodeCell = row.getCell(0);
      //这里可能出现有些单元格格式是数字，有些单元格格式的文本类型的恶心问题
      try {
        provinceCode = provinceCodeCell.getStringCellValue();
      } catch (Exception e) {
        provinceCode = String.valueOf(provinceCodeCell.getNumericCellValue());
        provinceCode = provinceCode.substring(0, provinceCode.length() - 2);
      }

      //城市编码
      String cityCode = StringUtils.EMPTY;
      Cell cityCodeCell = row.getCell(1);
      //这里可能出现有些单元格格式是数字，有些单元格格式的文本类型的恶心问题
      try {
        cityCode = cityCodeCell.getStringCellValue();
      } catch (Exception e) {
        cityCode = String.valueOf(cityCodeCell.getNumericCellValue());
        cityCode = cityCode.substring(0, cityCode.length() - 2);
      }

      String cityName = row.getCell(2).getStringCellValue();

      if (!StringUtils.equals(provinceCode, lastValue)) {
        //上一行和当前不相等，且当前行值是0，这种情况下是同一单元格
        if (StringUtils.equals(ZERO_STR, provinceCode)) {

          sb.append("INSERT INTO CITY(province_id, city_name, id) VALUES ('")
              .append(lastValue).append("', '").append(cityName)
              .append("', '").append(cityCode).append("');").append("\n");
        }
        //上一行和当前不相等，且当前行值不为0，这种情况为非同一单元格
        else {
          sb.append("INSERT INTO CITY(province_id, city_name, id) VALUES ('")
              .append(provinceCode).append("', '").append(cityName)
              .append("', '").append(cityCode).append("');").append("\n");
          lastValue = provinceCode;
        }
      }
    }

    String result = sb.toString();
    System.out.println(result);
    return result;
  }

  private static Workbook getWorkbook(String xlsxPath) {
    InputStream inputStream = XlsxUtils.class.getClassLoader().getResourceAsStream(xlsxPath);

    XSSFWorkbook xssfWorkbook = null;
    try {
      xssfWorkbook = new XSSFWorkbook(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return xssfWorkbook;
  }


  /*public static void main(String[] args) {
    String generateCitySql = generateCitySql("data/province_city.xlsx");
    try {
      File file = FileUtils.getFile("D://city.sql");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileUtils.writeStringToFile(file, generateCitySql, "UTF-8", false);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }*/
}