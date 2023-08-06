package com.example.demo67.mapper;

import com.example.demo67.entity.Report;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReportMapperTest {

    @Resource
    ReportMapper reportMapper;
    @Test
    void getAllReports() {
        List<Report> reports = reportMapper.getAllReports();
        System.out.println("reports = " + reports);
    }

    @Test
    void insert(){
        Report report = new Report();
        report.setReportName("巡检2");
        report.setReportDetails("内容1");
        int i = reportMapper.insertReport(report);
        System.out.println("i = " + i);
    }
}