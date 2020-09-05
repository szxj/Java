package com.szxj.javabase.CRAWLER.Jsop;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author suzhouxj
 *
 * www.open-open.com/jsoup
 *
 *
 */
public class JsoupTest {

    private String url = "http://www.4399.com";
    public static void main(String[] args) throws IOException {
        JsoupTest t = new JsoupTest();
        t.testGetDocmemt();
    }

    /*
    Jsoup入门案列
     */
    public void testGetDocmemt() throws IOException {
        //创建连接 get doc
        Document document = Jsoup.connect(url).get();

        Jsoup.parse(new URL(url),2000);
        //读文件搜索
       // Jsoup.parse(new File("jsoup.html"),"UTF-8");
        //字符串搜索
//        String fileString =
//                FileUtils.readFileToString(new File("jsoup.html"),"UTF-8");
//        Document parse = Jsoup.parse(fileString);

        System.out.println(document.toString());
        //获取第一个title
        Element title = document.getElementsByTag("title").first();
        System.out.println(title);
    }

    /*
    Jsoup获取元素
     */
    public void testGetElement() throws IOException{
        //创建连接 get doc
        Document document = Jsoup.connect(url).get();
        System.out.println(document);
        //根据Id getElementById
        Element s1 = document.getElementById("s1");
        String text = s1.text();

        //根据标签 getElementsByTag
        Elements elements = document.getElementsByTag("title");
        Element first = elements.first();
        String text1 = first.text();

        //根据class  getElementsByClass
        Elements elementsByClass = document.getElementsByClass("mi_tit");
        String text2 = elementsByClass.text();

        //根据属性获取元素
        document.getElementsByAttribute("_self").text();
    }

    /*
    Jsoup通过选择器选择元素
     */

    public void testSelect() throws IOException {
        Document document = Jsoup.connect(url).get();
        //根据标签名
        Elements spans = document.select("span");
        for (Element e:spans) {
            System.out.println(e.text());
        }

        //根据id获取元素
        String text = document.select("#s1").text();
        System.out.println(text);

        //根据class获取元素
        document.select(".s1").text();

        //根据属性获取属性
        document.select("[abc]");

        //根据属性值获取元素
        document.select("[class = s1]");

    }


    /*
    组合选取
     */
    public void testSelect2() throws IOException {
        Document document = Jsoup.connect(url).get();

        //根据元素+id组合选取元素 li标签 id=test
        document.select("li#test").text();

        //任意组合 标签span 属性abc class=s1
        document.select("span[abc].s1").text();
    }
}
