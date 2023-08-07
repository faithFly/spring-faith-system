package com.faith.controller;

import com.alibaba.fastjson.JSONArray;
import com.faith.domain.Person;
import com.faith.domain.PersonExport;
import com.faith.util.excel.ExcelUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
/**
 * @description:
 * @author:faith
 * @time:2023/6/2611:42
 */
@RestController
@RequestMapping("/api/excel")
public class ExcelController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("/import")
    public void importUser(@RequestPart("file")MultipartFile file) throws Exception {
        JSONArray arr = ExcelUtils.readMultipartFile(file);
        System.out.println(arr);
    }
    @PostMapping("/importPerson")
    public void importPerson(@RequestPart("file")MultipartFile file) throws Exception {
        List<Person> people = ExcelUtils.readMultipartFile(file, Person.class);
        for (Person p:
                people) {
            System.out.println(p);
        }
    }
    @PostMapping("/importPersonSheet")
    public void importPersonSheet(@RequestPart("file")MultipartFile file) throws Exception {
        Map<String, JSONArray> stringJSONArrayMap = ExcelUtils.readFileManySheet(file);
        stringJSONArrayMap.forEach((k,v)->{
            System.out.println("sheetName:" + k);
            System.out.println("sheetData" + v);
            System.out.println("---------------");
        });
    }
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws MalformedURLException {
//        // 表头数据
//        List<Object> head = Arrays.asList("姓名","年龄","性别","头像");
//        // 用户1数据
//        List<Object> user1 = new ArrayList<>();
//        user1.add("诸葛亮");
//        user1.add(60);
//        user1.add("男");
//        user1.add(new URL("https://profile.csdnimg.cn/A/7/3/3_sunnyzyq"));
//        // 用户2数据
//        List<Object> user2 = new ArrayList<>();
//        user2.add("大乔");
//        user2.add(28);
//        user2.add("女");
//        user2.add(new URL("https://profile.csdnimg.cn/6/1/9/0_m0_48717371"));
//        // 将数据汇总
//        List<List<Object>> sheetDataList = new ArrayList<>();
//        sheetDataList.add(head);
//        sheetDataList.add(user1);
//        sheetDataList.add(user2);
//        // 导出数据
//        ExcelUtils.export(response,"用户表", sheetDataList);
//        List<Object> head = Arrays.asList("姓名","年龄性别",ExcelUtils.COLUMN_MERGE,"地址",ExcelUtils.COLUMN_MERGE);
//        List<Object> user1 = new ArrayList<>();
//        user1.add("诸葛亮");
//        user1.add(60);
//        user1.add("男");
//        user1.add("杭州");
//        user1.add("**街道");
//        List<Object> user2 = new ArrayList<>();
//        user2.add("大桥");
//        user2.add(33);
//        user2.add("女");
//        user2.add("上海");
//        user2.add("**办事处");
//        //将数据汇总
//        List<List<Object>> sheetDataList = new ArrayList<>();
//        sheetDataList.add(head);
//        sheetDataList.add(user1);
//        sheetDataList.add(user2);
//
//        //设置下拉列表（键为第几列（从0开始），值为下拉数据）
//        Map<Integer,List<String>> selectMap = new HashMap<>(1);
//        selectMap.put(2,Arrays.asList("男","女"));
//
//        //导出数据
//        ExcelUtils.export(response,"faith",sheetDataList,selectMap);
//        List<PersonExport> userList = new ArrayList<>();
//        PersonExport export = new PersonExport("faith",22,1,"13732508975","hangzhou","https://images/03");
//        PersonExport export1 = new PersonExport("taylor",22,2,"13732508975","hangzhou","https://images/03");
//        userList.add(export);
//        userList.add(export1);
//        ExcelUtils.export(response,"test",userList,PersonExport.class);

        //第一个sheet
        /**
         * 导出多 Sheet 页实现
         */
            // 第 1 个 Sheet 页
            List<List<Object>> sheet1 = new ArrayList<>();
            List<Object> sheet1Head = new ArrayList<>();
            sheet1Head.add("姓名");
            sheet1Head.add("数学");
            sheet1Head.add("英语");
            sheet1.add(sheet1Head);
            List<Object> row1 = new ArrayList<>();
            row1.add("Jack");
            row1.add(85);
            row1.add(100);
            sheet1.add(row1);
            List<Object> row2 = new ArrayList<>();
            row2.add("Marry");
            row2.add(85);
            row2.add(100);
            sheet1.add(row2);
            // 第 2 个 Sheet 页
            List<List<Object>> sheet2 = new ArrayList<>();
            List<Object> sheet2Head = new ArrayList<>();
            sheet2Head.add("姓名");
            sheet2Head.add("音乐");
            sheet2Head.add("美术");
            sheet2.add(sheet2Head);
            List<Object> row01 = new ArrayList<>();
            row01.add("Jack");
            row01.add(77);
            row01.add(66);
            sheet2.add(row01);
            List<Object> row02 = new ArrayList<>();
            row02.add("Marry");
            row02.add(99);
            row02.add(88);
            sheet2.add(row02);
            // 将两个 Sheet 页添加到集合中
            Map<String, List<List<Object>>> sheets = new LinkedHashMap<>();
            sheets.put("文化课", sheet1);
            sheets.put("艺术课", sheet2);
            // 导出数据
            ExcelUtils.exportManySheet(response, "学生成绩表", sheets);
        }

    @GetMapping("/exportModel")
    public void exportModel(HttpServletResponse response){
    ExcelUtils.exportTemplate(response,"model", PersonExport.class,true);
    }
    @GetMapping("/test")
    public String dockerTest(){
        //打印当前路径
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
        logger.info("这是一条日志信息！！！");
        return "docker success!";
    }
}
