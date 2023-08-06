package report.service.impl;

import com.example.demo67.Demo67Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo67.report.entity.InspectionReportDataAO;
import com.example.demo67.report.service.InspectionReportDataService;

import javax.annotation.Resource;

import java.util.*;

@SpringBootTest(classes = Demo67Application.class)
class InspectionReportDataServiceImplTest {

    @Resource
    private InspectionReportDataService service;

    @Test
    void insertReportDataByAO() {
        InspectionReportDataAO ao = new InspectionReportDataAO();
        ao.setReportName("测试报告1");
        ao.setReceiveName("接收人姓名1");
        ao.setTaskName("测试任务1");
        ao.setTaskType("测试类型1");
        ao.setSendTime(new Date());
        ao.setInspectionTime(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("filedName","code");
        map.put("objectData","mockdata");
        ao.setPythonUtilsDetailList(map);
        int i = service.insertReportDataByAO(ao);
        System.out.println("i = " + i);
    }

    @Test
    void select(){
        List<InspectionReportDataAO> list = service.getReportDataByList(Arrays.asList(4, 3));
        System.out.println("list = " + list);
    }
}