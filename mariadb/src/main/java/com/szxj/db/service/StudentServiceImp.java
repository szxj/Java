package com.szxj.db.service;

import com.szxj.db.entity.student;
import com.szxj.db.mapper.StudentMapper;
import com.szxj.db.service.imp.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suzhouxj
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<student> getAll(){
        return studentMapper.getAll();
    }


}
