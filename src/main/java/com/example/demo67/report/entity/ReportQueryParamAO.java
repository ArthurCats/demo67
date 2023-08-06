package com.example.demo67.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/6 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportQueryParamAO {
    private List<Integer> list;
}
