package com.szxj.so.normal;

import org.springframework.stereotype.Service;

/**
 * @author suzhouxj
 */
@Service
public class ClassB implements IntA{


    public String out() {
        System.out.println("B");
        return "B";
    }
}
