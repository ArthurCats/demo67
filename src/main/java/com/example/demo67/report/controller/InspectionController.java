package com.example.demo67.report.controller;

import com.example.demo67.commons.BaseResponse;
import com.example.demo67.report.entity.InspectionReportData;
import com.example.demo67.report.entity.ReportQueryParamAO;
import com.example.demo67.report.service.InspectionReportDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/6 16:51
 */
@RestController
@RequestMapping("/check")
public class InspectionController {
    @Resource
    private InspectionReportDataService service;

    @GetMapping("/data")
    public BaseResponse<?> getAllData(@RequestParam Integer reportId){
        return BaseResponse.success(666,"success！",service.getReportDataById(reportId));
    }

    @PostMapping("/list")
    public BaseResponse<?> getReportDataByList(@RequestBody ReportQueryParamAO queryParamAO){
        return BaseResponse.success(888,"success",service.getReportDataByList(queryParamAO.getList()));
    }
}
