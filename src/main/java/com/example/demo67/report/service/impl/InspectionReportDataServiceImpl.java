package report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import report.entity.InspectionReportData;
import report.dao.InspectionReportDataDao;
import report.entity.InspectionReportDataAO;
import report.service.InspectionReportDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
