package com.szxj.so.normal;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author suzhouxj
 */
public class run {
    @Autowired
    IntA inta;
    public static void main(String[] args) {

    }

    public void t1(){
        inta.out();
    }
}
