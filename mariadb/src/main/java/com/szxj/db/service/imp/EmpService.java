package com.szxj.db.service.imp;

import com.szxj.db.entity.emp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suzhouxj
 */
public interface EmpService {

    List<emp> getAll();

}
