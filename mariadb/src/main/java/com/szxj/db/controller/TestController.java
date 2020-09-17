package com.szxj.db.controller;

import com.szxj.db.entity.student;
import com.szxj.db.mapper.StudentMapper;
import com.szxj.db.service.StudentService;
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

        @RequestMapping("/test")
        public String t1(){
             List<student> all = studentService.Sel();
            student student = all.get(0);
            return student.getName();
        }
}
