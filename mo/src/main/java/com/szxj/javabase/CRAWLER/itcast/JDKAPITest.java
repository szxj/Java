package com.szxj.javabase.CRAWLER.itcast;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author suzhouxj
 */

public class JDKAPITest {
    public static void main(String[] args) throws IOException {
        toGet();
       // toPost();
    }

    public static void toGet() throws IOException {
        //确定访问的地址
        URL url = new URL("http://www.4399.com");

        //获取连接对象
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        //设置连接信息
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        urlConnection.setConnectTimeout(3000);
        //获取信息
        InputStream in = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"gb2312"));

        String line;
        String html="";

        while ((line = bufferedReader.readLine())!=null){
            html += line +"\n";
        }
        System.out.println(html);

        //关闭连接
        in.close();
        bufferedReader.close();

    }

    public static void toPost() throws IOException {
        //确定url
        URL url = new URL("http://www.itcast.cn");
        //获取连接
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        //设置连接信息
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        urlConnection.setConnectTimeout(3000);

        OutputStream out = urlConnection.getOutputStream();
        out.write("username".getBytes());

        //获取信息
        InputStream in = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"UTF-8"));

        String line;
        String html="";

        while ((line = bufferedReader.readLine())!=null){
            html += line +"\n";
        }
        System.out.println(html);

        //关闭连接
        in.close();
        bufferedReader.close();

    }
}
