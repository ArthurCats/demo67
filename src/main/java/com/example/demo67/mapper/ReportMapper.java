package com.example.demo67.mapper;

import com.example.demo67.entity.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    List<Report> getAllReports();

    int insertReport(Report report);
}
