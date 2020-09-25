package com.szxj.so.normal;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author suzhouxj
 */
@Service
public class ClassA implements IntA {

    @Override
    public String out() {
        System.out.println("A");
        return "A";
    }
}
