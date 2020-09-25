package com.szxj.so.normal;

import com.szxj.db.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author suzhouxj
 */
@Component
public class TestM {
    @Autowired
    EmpMapper empMapper;
}
