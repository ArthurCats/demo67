package report.service;

import report.entity.InspectionReportData;
import report.entity.InspectionReportDataAO;


/**
 * (InspectionReportData)表服务接口
 *
 * @author makejava
 * @since 2023-08-06 15:17:38
 */
public interface InspectionReportDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param reportId 主键
     * @return 实例对象
     */
    InspectionReportData queryById(Integer reportId);

    /**
     * 新增数据
     *
     * @param inspectionReportData 实例对象
     * @return 实例对象
     */
    InspectionReportData insert(InspectionReportData inspectionReportData);

    /**
     * 修改数据
     *
     * @param inspectionReportData 实例对象
     * @return 实例对象
     */
    InspectionReportData update(InspectionReportData inspectionReportData);

    /**
     * 通过主键删除数据
     *
     * @param reportId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer reportId);

    /**
     * 根据ao来新增报告数据
     *
     * @param ao ao
     * @return 结果
     */
    int insertReportDataByAO(InspectionReportDataAO ao);

}
