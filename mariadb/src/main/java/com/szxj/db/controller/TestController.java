package com.szxj.db.controller;

import com.szxj.db.entity.emp;
import com.szxj.db.entity.student;
import com.szxj.db.mapper.EmpMapper;
import com.szxj.db.service.imp.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author suzhouxj
 */
@RestController
public class TestController {
        @Autowired
        StudentService studentService;

        @Autowired
        EmpMapper empMapper;
        @RequestMapping("/test")
        public String t1(){
            StringBuffer strb = new StringBuffer();
            List<student> all = studentService.getAll();
            for (student s:all) {
                strb.append(s.getId()+"|"+s.getName()+"\n");
            }
            return strb.toString();
        }

    @RequestMapping("/test2")
    public String t2(){
        StringBuffer strb = new StringBuffer();
        List<emp> all = empMapper.getAll();
        for (emp s:all) {
            strb.append(s.getId()+"|"+s.getName());
            strb.append("\r\n");
        }
        return strb.toString();
    }


}
