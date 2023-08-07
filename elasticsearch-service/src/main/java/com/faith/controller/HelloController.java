package com.faith.controller;

import com.faith.domain.Goods;
import com.faith.mapper.GoodsMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description:
 * @author:faith
 * @time:2023/6/1316:14
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @Autowired
    private GoodsMapper mapper;
    @GetMapping()
    public String hello() throws IOException {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA";
        //解析网页(静态html文件)
        Document document = Jsoup.parse(new URL(url), 20000);
        //所有再js中使用的方法再这里都可以使用
        Element element = document.getElementById("J_goodsList");
        //获取所有的list元素
        Elements elements = element.getElementsByTag("li");
        //获取所有li中的内容
        for (Element el:
                elements) {
            if (el.className().equals("ps-item")){
                continue;
            }
            Goods goods = new Goods();
            //img属性
            goods.setUrl(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
            //price
            goods.setPrice(new BigDecimal(el.getElementsByClass("p-price").eq(0).text().replace("￥","")));
            //title
            goods.setTitle(el.getElementsByClass("p-name").eq(0).text());
            //shop
            goods.setShop(el.getElementsByClass("p-shop").eq(0).text());
            mapper.insert(goods);
        }
        return "Ok";
    }

}
