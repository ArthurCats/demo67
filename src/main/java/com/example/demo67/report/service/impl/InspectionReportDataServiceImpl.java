package com.example.demo67.report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo67.report.dao.InspectionReportDataDao;
import com.example.demo67.report.entity.InspectionReportData;
import com.example.demo67.report.entity.InspectionReportDataAO;
import com.example.demo67.report.service.InspectionReportDataService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (InspectionReportData)表服务实现类
 *
 * @author makejava
 * @since 2023-08-06 15:17:42
 */
@Service("inspectionReportDataService")
public class InspectionReportDataServiceImpl implements InspectionReportDataService {
    @Resource
    private InspectionReportDataDao inspectionReportDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param reportId 主键
     * @return 实例对象
     */
    @Override
    public InspectionReportData queryById(Integer reportId) {
        return this.inspectionReportDataDao.queryById(reportId);
    }

    /**
     * 新增数据
     *
     * @param inspectionReportData 实例对象
     * @return 实例对象
     */
    @Override
    public InspectionReportData insert(InspectionReportData inspectionReportData) {
        this.inspectionReportDataDao.insert(inspectionReportData);
        return inspectionReportData;
    }

    /**
     * 修改数据
     *
     * @param inspectionReportData 实例对象
     * @return 实例对象
     */
    @Override
    public InspectionReportData update(InspectionReportData inspectionReportData) {
        this.inspectionReportDataDao.update(inspectionReportData);
        return this.queryById(inspectionReportData.getReportId());
    }

    /**
     * 通过主键删除数据
     *
     * @param reportId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer reportId) {
        return this.inspectionReportDataDao.deleteById(reportId) > 0;
    }

    /**
     * 通过id获取报告数据,返回ao对象
     *
     * @param reportId 报告id
     * @return {@link InspectionReportDataAO}
     */
    @Override
    public InspectionReportDataAO getReportDataById(Integer reportId) {
        // 查找
        InspectionReportData data = queryById(reportId);
        // 转换
        return exchangeToAO(data);
    }

    /**
     * 根据ao来新增报告数据
     *
     * @param ao ao
     * @return int
     */
    @Override
    public int insertReportDataByAO(InspectionReportDataAO ao) {
        // 分别获取sql、python、api执行结果，然后处理
        String sql = "";
        String python = "";
        String api = "";
        if (ao.getSqlUtilsDetailList() != null){
            sql = JSONUtil.toJsonStr(ao.getPythonUtilsDetailList());
        }
        if(ao.getPythonUtilsDetailList() != null){
            python = JSONUtil.toJsonStr(ao.getPythonUtilsDetailList());
        }
        if(ao.getApiUtilsDetailList() != null){
            api = JSONUtil.toJsonStr(ao.getApiUtilsDetailList());
        }
        InspectionReportData data = new InspectionReportData();
        // 复制相等的属性到data
        BeanUtil.copyProperties(ao,data);
        data.setPythonUtilsDetailList(python);
        data.setSqlUtilsDetailList(sql);
        data.setApiUtilsDetailList(api);
        return this.inspectionReportDataDao.insert(data);
    }

    /**
     * 得到报告数据列表，批量查询
     *
     * @param list 列表
     * @return 查询结果
     */
    @Override
    public List<InspectionReportDataAO> getReportDataByList(List<Integer> list){
        List<InspectionReportData> data = inspectionReportDataDao.getReportDataByList(list);
        List<InspectionReportDataAO> res = new ArrayList<>();
        // 数据转换为ao
        for (InspectionReportData datum : data) {
            // 转换
            res.add(exchangeToAO(datum));
        }
        return res;
    }

    /**
     * 转换为ao
     *
     * @param data 数据
     * @return 处理结果
     */
    private InspectionReportDataAO exchangeToAO(InspectionReportData data){
        // 转换
        InspectionReportDataAO ao = new InspectionReportDataAO();
        // 复制相同的属性
        BeanUtil.copyProperties(data,ao);
        // 处理3种执行结果
        Object python = null;
        Object sql = null;
        Object api = null;
        if(!data.getPythonUtilsDetailList().equals("")){
            python = JSONUtil.parseObj(data.getPythonUtilsDetailList());
        }
        if(!data.getSqlUtilsDetailList().equals("")){
            sql = JSONUtil.parseObj(data.getSqlUtilsDetailList());
        }
        if(!data.getApiUtilsDetailList().equals("")){
            api = JSONUtil.parseObj(data.getApiUtilsDetailList());
        }
        ao.setPythonUtilsDetailList(python);
        ao.setApiUtilsDetailList(api);
        ao.setSqlUtilsDetailList(sql);
        return ao;
    }
}
