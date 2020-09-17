package com.szxj.javabase.JDK.BigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author suzhouxj
 *
 * 精度运算BigDecimal
 */
public class Big {

    public static void main(String[] args) {


        BigDecimal big = new BigDecimal(BigInteger.ONE);
        BigDecimal big2 = BigDecimal.valueOf(0.02);

        //big&big
        big2.add(big);//加法
        big2.multiply(big);//乘法
        big2.divide(big);//除法
        big2.subtract(big);//减法


    }

}
