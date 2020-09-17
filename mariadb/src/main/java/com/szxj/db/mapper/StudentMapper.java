package com.szxj.db.mapper;

import com.szxj.db.entity.student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suzhouxj
 */
@Repository
public interface StudentMapper {
    public List<student> getAll();
}
