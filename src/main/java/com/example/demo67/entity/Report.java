package com.example.demo67.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 17:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private Integer reportId;

    private String reportName;

    private String reportDetails;
}
