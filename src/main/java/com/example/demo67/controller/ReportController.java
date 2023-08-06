package com.example.demo67.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo67.commons.BaseResponse;
import com.example.demo67.entity.Report;
import com.example.demo67.entity.dto.ReportDTO;
import com.example.demo67.service.impl.ReportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 18:21
 */
@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportServiceImpl reportService;

    @GetMapping("/export")
    public BaseResponse<?> getAll(){
        // 处理数据
        List<Report> all = reportService.getAll();
        List<ReportDTO> res = new ArrayList<>();
        for (Report report : all) {
            String details = report.getReportDetails();
            // J
            JSONObject obj = JSONUtil.parseObj(details);
            ReportDTO dto = new ReportDTO();
            dto.setReportName(report.getReportName());
            dto.setReportId(report.getReportId());
            dto.setReportDetails(obj);
            res.add(dto);
        }

        return BaseResponse.success(600,"成功",res);
    }

    @GetMapping("/add")
    public BaseResponse<?> add(){
        return BaseResponse.success(600,"成功",reportService.insertJson());
    }
}
