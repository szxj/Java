package com.szxj.javabase.CRAWLER.project1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.szxj.javabase.CRAWLER.httpClient.HttpClientUtils;
import com.szxj.javabase.CRAWLER.project1.Bean.CovidBean;
import com.szxj.javabase.Uitls.TimeUitls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author suzhouxj
 *
 * 项目名称:疫情数据爬取
 * Jsoup+Kafka+commons
 */
public class Covid19DataCrawler {

    //疫情数据网站
    private static String webUrl = "https://ncov.dxy.cn/ncovh5/view/pneumonia";

    public static void main(String[] args) {
        testCrawling();
    }

    //后续将该方法改成定时任务
    public static void testCrawling(){
        String thisTime = TimeUitls.format(System.currentTimeMillis(),"yyyy-MM-dd");

        //1.爬取指定页面
        String html = HttpClientUtils.getHtml(webUrl);


        //2.解析html内容
        Document document = Jsoup.parse(html);
        String text = document.select("script[id = getAreaStat]").toString();


        //3.使用正则获取json数据
        String pattren = "\\[(.*)\\]";
        Pattern reg = Pattern.compile(pattren);
        Matcher matcher = reg.matcher(text);
        String group ="";
        if(matcher.find()){
            group= matcher.group(0);
        }else {
            System.out.println("no match!!!!");
        }

        //4.对Json数据进一步解析
        //将省份数据解析
        List<CovidBean> beanList = JSON.parseArray(group, CovidBean.class);
        for (CovidBean bigCity:beanList) {
            //设置时间字段
            bigCity.setDateTime(thisTime);
            //获取cities
            String cities = bigCity.getCities();
            //5.将第二层Json(城市数据)解析为JavaBean
            List<CovidBean> covidBeans = JSON.parseArray(cities, CovidBean.class);
            for (CovidBean city:covidBeans
                 ) {
                city.setDateTime(thisTime);
                city.setPid(bigCity.getLocationId());
                city.setProvinceShortName(bigCity.getProvinceShortName());
            }
        //6.将省份数据的每天数据进行统计
            String dayUrl = bigCity.getStatisticsData();
            String dayDataStr = HttpClientUtils.getHtml(dayUrl);
            JSONObject jsonObject = JSON.parseObject(dayDataStr);
            String dataStr = jsonObject.getString("data");

            //将解析出的每天数据设置回BigCity
            bigCity.setStatisticsData(dataStr);
            bigCity.setCities(null);
            System.out.println(bigCity);
        }

    }
}
