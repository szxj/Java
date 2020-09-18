package com.szxj.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author suzhouxj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class emp {
    private Integer id;
    private String name;
    private String job;
    private String salary;
}
