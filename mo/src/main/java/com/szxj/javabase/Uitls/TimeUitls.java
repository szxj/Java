package com.szxj.javabase.Uitls;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @author suzhouxj
 */
public abstract class TimeUitls {
    public static  String format(Long timeStamp,String pattern){

        return FastDateFormat.getInstance(pattern).format(timeStamp);
    }


}
