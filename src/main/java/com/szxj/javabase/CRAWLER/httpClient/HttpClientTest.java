package com.szxj.javabase.CRAWLER.httpClient;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.security.auth.message.config.ServerAuthConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suzhouxj
 */
public class HttpClientTest {
    private static String webSite = "http://www.itcast.cn";
    public static void main(String[] args) throws IOException {
        //toGet();
        //
        toPost();
    }

    public static void toGet() throws IOException {
        //1.HttpClient
        CloseableHttpClient client = HttpClients.createDefault();
        //2.Get请求
        HttpGet httpGet = new HttpGet("http://www.4399.com");
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");

        //3.发起请求
        CloseableHttpResponse response = client.execute(httpGet);

        //4.获取响应数据
        if(response.getStatusLine().getStatusCode() ==200){
            String s = EntityUtils.toString(response.getEntity(), "gb2312");
            System.out.println(s);
        }
        //5.关闭资源
        client.close();
        response.close();
    }

    public static void toPost() throws IOException {
        //1.HttpClient
        CloseableHttpClient client = HttpClients.createDefault();
        //2.Post请求
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");
        //准备集合
        List<NameValuePair> params= new ArrayList<>();
        params.add(new BasicNameValuePair("123","123"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(urlEncodedFormEntity);
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");

        //3.发起请求
        CloseableHttpResponse response = client.execute(httpPost);

        //4.获取响应数据
        if(response.getStatusLine().getStatusCode() ==200){
            String s = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(s);
        }
        //5.关闭资源
        client.close();
        response.close();
    }

    public static void httpClientPool() throws IOException {

        //1.创建HttpClient连接管理器
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        //2.设置参数
        pool.setMaxTotal(200);//设置最大连接数
        pool.setDefaultMaxPerRoute(20);
        doGet(pool);
        doPost(pool);

    }

    private static void  doGet(PoolingHttpClientConnectionManager pool) throws IOException {
        //3.从连接池中获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pool).build();
        //4.创建HttpGet
        HttpGet httpGet = new HttpGet(webSite);
        //5.发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //6.获取数据
        if(response.getStatusLine().getStatusCode() ==200){
            String s = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(s);
        }
        //7.关闭资源
        response.close();
        //连接池不用关闭client
    }

    private static void  doPost(PoolingHttpClientConnectionManager pool){

    }

    public static  void testConfig() throws IOException {
        //0.创建请求配置对象
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(10000)//设置连接超时时间
                .setConnectTimeout(10000)//设置连接创建时间

                .setProxy(new HttpHost("211.137.52.158",8080)) //代理服务器 https://proxy.mimvp.com/freeopen


                .setConnectionRequestTimeout(10000).build();//设置请求超市时间

        //1.创建HttpClient
        //CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config).build();
        //2.创建HttpGet对象
        HttpGet httpGet = new HttpGet(webSite);
        //3.发起请求
        CloseableHttpResponse response = client.execute(httpGet);
        //4.获取数据
        if(response.getStatusLine().getStatusCode() ==200){
            String s = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(s);
        }
        //5.关闭资源
        client.close();
        response.close();
    }


}
