package com.szxj.javabase.CRAWLER.httpClient;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author suzhouxj
 *
 * HttpClient管理工具
 *
 */
public abstract class HttpClientUtils {
    private static  PoolingHttpClientConnectionManager pool;//声明HttpClient连接池

    private static List<String> userAgentList = null;

    private static RequestConfig config = null;

    //静态代码块会在类被加载时候执行
    static {
        pool = new PoolingHttpClientConnectionManager();
        pool.setMaxTotal(200);
        pool.setDefaultMaxPerRoute(20);

        config = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        userAgentList = new ArrayList<>();

        userAgentList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");

    }

     public static String getHtml(String url) {
        //1.从连接池中获取HttpClient对象
         CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pool).build();
         //2.创建HttpGet
         HttpGet httpGet = new HttpGet(url);
        //3.设置请求配置对象头
         httpGet.setConfig(config);
         httpGet.setHeader("User-AgentList",userAgentList.get(new Random().nextInt(userAgentList.size())));
         //4.发起请求
         CloseableHttpResponse response = null;
         try {
             response = httpClient.execute(httpGet);

             //5.获取响应内容
             if(response.getStatusLine().getStatusCode() ==200){
                 if (response.getEntity()!=null){
                     String s = EntityUtils.toString(response.getEntity(), "UTF-8");
                     return  s;
                 }
             }
         }catch (IOException e) {
             e.printStackTrace();
         }finally {
             try {
                 response.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         return null;
     }

    public static void main(String[] args) {

        System.out.println(HttpClientUtils.getHtml("http://www.itcast.cn"));
    }
}
