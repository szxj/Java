package com.szxj.db;

import com.szxj.db.entity.emp;
import com.szxj.db.entity.student;
import com.szxj.db.mapper.EmpMapper;
import com.szxj.db.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author suzhouxj
 */
@SpringBootTest
public class testM {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    StudentMapper studentMapper;
    @Test
    public void insertTest(){
        emp e = new emp();
        e.setId(123);
        e.setName("xujie");
        e.setJob("java");
        e.setSalary("5000");
        int insert = empMapper.insertOne(e);
        System.out.println(insert);
    }

    @Test
    public void updateTest(){
        emp e = new emp();
        e.setId(9);
        e.setName("xujie222");
        e.setJob("java");
        e.setSalary("5000");
        int update = empMapper.updateOne(e);

        System.out.println(update);
    }

    @Test
    public  void t3(){
        List<emp> all = empMapper.getAll();
        System.out.println(all);
        List<student> all1 = studentMapper.getAll();
        System.out.println(all1);
    }
}
