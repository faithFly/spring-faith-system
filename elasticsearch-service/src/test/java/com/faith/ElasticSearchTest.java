package com.faith;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.faith.constants.TestEnum;
import com.faith.domain.Goods;
import com.faith.domain.UserInfo;
import com.faith.mapper.GoodsMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static com.faith.constants.faithContants.MAPPING_TEMPLATE;

/**
 * @description:
 * @author:faith
 * @time:2023/5/3017:11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticSearchTest {
    private RestHighLevelClient client;
    @Autowired
    private GoodsMapper mapper;
    @Test
    public void addMapping() throws IOException {
        //System.out.println(client);
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        CreateIndexRequest request = new CreateIndexRequest("faith");
        request.source(MAPPING_TEMPLATE, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
        this.client.close();
    }
    @Test
   public void deleteMapping() throws IOException {
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        DeleteIndexRequest request = new DeleteIndexRequest("faith");
        client.indices().delete(request, RequestOptions.DEFAULT);
        this.client.close();
    }
    //新建文档
    @Test
    public void addDoc() throws IOException {
        UserInfo user = new UserInfo(12138L,"faith3Zz",27);
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        IndexRequest request = new IndexRequest("user").id(user.getId().toString());
        //json文档
        request.source(JSON.toJSONString(user),XContentType.JSON);
        //发送请求
        this.client.index(request,RequestOptions.DEFAULT);
        this.client.close();
    }

    //查询文档
    @Test
    public void selectDoc() throws IOException {
        UserInfo user = new UserInfo(12138L,"faith3Zz",27);
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        GetRequest request = new GetRequest("user","12138");
        GetResponse documentFields = client.get(request, RequestOptions.DEFAULT);
        String sourceAsString = documentFields.getSourceAsString();
        UserInfo userInfo = JSON.parseObject(sourceAsString, UserInfo.class);
        System.out.println(userInfo);
        this.client.close();
    }
    //更新文档
    @Test
    public void updateDoc() throws IOException {
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        UpdateRequest request =new UpdateRequest("user","12138");
        request.doc(
                "age",25,
                "name","evil"
        );
        this.client.update(request,RequestOptions.DEFAULT);
        this.client.close();
    }
    //删除文档
    @Test
    public void deleteDoc() throws IOException {
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        DeleteRequest request = new DeleteRequest("user","12138");
        this.client.delete(request,RequestOptions.DEFAULT);
        this.client.close();
    }
    @Test
    public void bulkRequest() throws IOException {
        this.client = new RestHighLevelClient(RestClient.builder(new HttpHost("120.79.81.249",9200)));
        List<Goods> list = mapper.selectList(null);
        BulkRequest request = new BulkRequest();
        for (Goods goods:
             list) {
            request.add(new IndexRequest("goods").id(goods.getId().toString()).source(JSON.toJSONString(goods),XContentType.JSON));
        }
        client.bulk(request,RequestOptions.DEFAULT);
    }
    @Test
    public void startData() throws IOException {
        StringBuilder sb = new StringBuilder("https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&page=");
        for (int i = 1; i < 100; i++) {
            sb.append("https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&page="+i);
            //解析网页(静态html文件)
            Document document = Jsoup.parse(new URL(sb.toString()), 20000);
            System.out.println(document);
            //所有再js中使用的方法再这里都可以使用
            Element element = document.getElementById("J_goodsList");
            //获取所有的list元素
            Elements elements = element.getElementsByTag("li");
            if (elements == null){
                continue;
            }
            //获取所有li中的内容
            for (Element el:
                    elements) {
                if (el.className().equals("ps-item")){
                    continue;
                }
                //System.out.println(el.html());
                Goods goods = new Goods();
                //img属性
                goods.setUrl(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
                String price = el.getElementsByClass("p-price").eq(0).text().replace("￥", "");
                if (price.contains(" ")){
                    //price
                    goods.setPrice(new BigDecimal(price.split(" ")[0]));
                }else if (price.contains("暂无报价")){
                    goods.setPrice(new BigDecimal(0.00));
                }else {
                    //price
                    goods.setPrice(new BigDecimal(price));
                }
                //title
                goods.setTitle(el.getElementsByClass("p-name").eq(0).text());
                //shop
                goods.setShop(el.getElementsByClass("p-shop").eq(0).text());
                mapper.insert(goods);
            }
            sb.setLength(0);
        }
        System.out.println("success!");
    }
    @Test
    public void urlConnectTest() throws IOException {
        //下载资源
        URL url = new URL("https://search.jd.com/Search?keyword=%E8%A1%A3%E6%9C%8D&page=1");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = conn.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != 1){
            fileOutputStream.write(buffer,0,len);
        }
    }
    @Test
    public void urlGetHtml(){
        CloseableHttpClient aDefault = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //创建一个get请求
        HttpGet request = new HttpGet("https://search.jd.com/Search?keyword=%E8%A1%A3%E6%9C%8D&page=");
        try{
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = aDefault.execute(request);
            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(aDefault);
        }
    }

    @Test
    public void test111(){
        write(TestEnum.吃饭);
    }
    public void write(TestEnum testEnum){
        System.out.println(testEnum);
        System.out.println(testEnum.getCode());
        System.out.println(TestEnum.喝酒);
        System.out.println(TestEnum.喝酒.getCode());
    }
}
