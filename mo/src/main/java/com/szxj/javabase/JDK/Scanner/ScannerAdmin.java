package com.szxj.javabase.JDK.Scanner;

import java.util.Scanner;

/**
 * @author suzhouxj
 */
public class ScannerAdmin {

    public static void main(String[] args) {
        int age=0;

        Scanner s = new Scanner(System.in);

        String username = s.nextLine();
        String password = s.nextLine();

        if (s.hasNextInt()){
            age = s.nextInt();
        }else{
            System.out.println("登陆失败");
            return;
        }


        if (username.trim().equals("admin") && password.trim().equals("admin") ){
            System.out.println("登陆成功"+age);
        }else {
            System.out.println("登陆失败");
        }

    }
}
