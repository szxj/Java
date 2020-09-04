package com.szxj.javabase.JDK.Scanner;

import java.util.Scanner;

/**
 * @author suzhouxj
 */
public class ScannerTest {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        s.next();
        // 输入
        // s.nextXXX XXX为具体类型 如果输入类型错误会报错

        s.hasNext();
        //是否有下一个，没有输入则会一直运行
        // s.hasNextXXX 是否是整数
        //System.out.println(str);

        s.nextLine();
        //一行输入，与next()区别是输入能带空格
    }

    private void t1(){
        Scanner s = new Scanner(System.in);
        if(s.hasNextInt()){
            int i = s.nextInt();
            System.out.println( "下一个整数是 :" + i);
        }else {
            System.out.println( "输入的不是整数" );
        }
    }
}
