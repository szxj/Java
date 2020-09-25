package com.szxj.db.service.imp;

import com.szxj.db.entity.emp;
import com.szxj.db.entity.student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suzhouxj
 */

public interface StudentService {

    List<student> getAll();

}
