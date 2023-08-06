package com.example.demo67.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/6 10:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private Integer reportId;

    private String reportName;

    private Object reportDetails;
}
