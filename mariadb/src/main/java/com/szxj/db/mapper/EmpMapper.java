package com.szxj.db.mapper;

import com.szxj.db.entity.emp;
import com.szxj.db.entity.student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suzhouxj
 */
@Repository
public interface EmpMapper {
    List<emp> getAll();

    int insertOne(emp e);

    int updateOne(emp e);

    int delectOne(emp e);

}
