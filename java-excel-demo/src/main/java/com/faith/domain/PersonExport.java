package com.faith.domain;

import com.faith.util.excel.ExcelExport;
import com.faith.util.excel.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:faith
 * @time:2023/6/2615:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonExport {
    @ExcelExport(value = "姓名",example = "张三")
    private String name;
    @ExcelExport(value = "年龄",example = "28")
    private Integer age;
    @ExcelExport(value = "性别",example = "1",kv = "1-男;2-女")
    private Integer sex;
    @ExcelExport(value = "电话",example = "13888888888")
    private String phone;
    @ExcelExport(value = "城市",example = "上海")
    private String city;
    @ExcelExport(value = "头像",example = "https://images")
    private String url;
}
