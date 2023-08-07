package com.faith.domain;

import com.faith.util.excel.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:faith
 * @time:2023/6/2613:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @ExcelImport(value = "姓名",required = true)
    private String name;
    @ExcelImport("年龄")
    private Integer age;
    @ExcelImport(value = "性别",kv = "1-男;2-女")
    private String sex;
    @ExcelImport(value = "电话",maxLength = 11)
    private String phone;
    @ExcelImport("城市")
    private String city;
    @ExcelImport("头像")
    private String url;
    //当前行数
    private int rowNum;
    //原始数据
    private String rowData;
    //错误提示
    private String rowTips;
}
