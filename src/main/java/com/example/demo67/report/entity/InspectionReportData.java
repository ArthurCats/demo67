package report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (InspectionReportData)实体类
 *
 * @author makejava
 * @since 2023-08-06 15:17:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionReportData implements Serializable {
    private static final long serialVersionUID = -63613090371041465L;
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
    private String sqlUtilsDetailList;
    /**
     * python执行结果
     */
    private String pythonUtilsDetailList;
    /**
     * api执行结果
     */
    private String apiUtilsDetailList;
}

