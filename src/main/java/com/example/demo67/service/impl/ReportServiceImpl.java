package com.example.demo67.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.demo67.entity.Report;
import com.example.demo67.mapper.ReportMapper;
import com.example.demo67.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 18:18
 */
@Service
public class ReportServiceImpl implements ReportService {
    private final ReportMapper reportMapper;
    private ReportServiceImpl(ReportMapper reportMapper){
        this.reportMapper = reportMapper;
    }

    public int insertReport(Report report){
        return reportMapper.insertReport(report);
    }

    public List<Report> getAll(){
        return reportMapper.getAllReports();
    }

    public int insertJson(){
        // 模拟工具执行结果
        Map<String, Object> res = new HashMap<>();
        res.put("curreny","900");
        Map<String, Object> map = new HashMap<>();
        map.put("utilId",2);
        map.put("pythonScriptResult",res);
        // 序列化
        String s = JSONUtil.toJsonStr(map);
        Report report = new Report();
        report.setReportName("v报告2");
        report.setReportDetails(s);
        return reportMapper.insertReport(report);
    }
}
