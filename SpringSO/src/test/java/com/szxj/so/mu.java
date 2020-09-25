package com.szxj.so;

import com.szxj.db.entity.emp;
import com.szxj.db.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author suzhouxj
 */

@SpringBootTest
public class mu {

    @Autowired
    EmpMapper empMapper;

    @Test
    public void t1(){

        System.out.println(empMapper.getAll());
    }
}
