package com.szxj.javabase.JDK.Scanner;

import java.util.Scanner;

/**
 * @author suzhouxj
 */
public class ScannerAdmin1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String username = s.nextLine();
        String password = s.nextLine();

        if (username == "admin" && password =="admin"){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }

    }
}
