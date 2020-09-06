package com.szxj.javabase.CRAWLER.project1.Bean;

import lombok.*;

/**
 * @author suzhouxj
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CovidBean {
    
  private String provinceName;
  private String provinceShortName;
  private String cityName;
  private String currentConfirmedCount;
  private String suspectedCount;
  private String curedCount;
  private String deadCount;
  private String locationId;
  private String pid;
  private String statisticsData;
  private String cities;
  private String dateTime;


}
