package com.example.demo67.report.dao;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo67.report.entity.InspectionReportData;

import java.util.List;

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

    /**
     * 得到报告数据列表，批量查询
     *
     * @param list 列表
     * @return 结果集
     */
    List<InspectionReportData> getReportDataByList(List<Integer> list);

}

