package report.dao;

import org.apache.ibatis.annotations.Mapper;
import report.entity.InspectionReportData;

@Mapper
public interface InspectionReportDataDao {

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
     * @return 影响行数
     */
    int insert(InspectionReportData inspectionReportData);

    /**
     * 修改数据
     *
     * @param inspectionReportData 实例对象
     * @return 影响行数
     */
    int update(InspectionReportData inspectionReportData);

    /**
     * 通过主键删除数据
     *
     * @param reportId 主键
     * @return 影响行数
     */
    int deleteById(Integer reportId);

}

