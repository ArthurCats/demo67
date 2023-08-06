package com.example.demo67.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/6 15:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectionReportDataAO {
    /**
     * 主键id
     */
    private Integer reportId;
    /**
     * 报告名称
     */
    private String reportName;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务类型
     */
    private String taskType;
    /**
     * 接收人姓名
     */
    private String receiveName;
    /**
     * 巡检结果状态
     */
    private Integer inspectionResult;
    /**
     * 巡检日期
     */
    private Date inspectionTime;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 发送类型
     */
    private String sendType;
    /**
     * sql执行结果
     */
    private Object sqlUtilsDetailList;
    /**
     * python执行结果
     */
    private Object pythonUtilsDetailList;
    /**
     * api执行结果
     */
    private Object apiUtilsDetailList;
}
