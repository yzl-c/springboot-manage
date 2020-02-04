package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.base.DictypeConstant;
import owner.yuzl.manage.entity.po.ApplyHoliday;
import owner.yuzl.manage.entity.po.ProcessHoliday;
import owner.yuzl.manage.mapper.ProcessHolidayMapper;
import owner.yuzl.manage.service.ApplyHolidayService;
import owner.yuzl.manage.service.ProcessHolidayService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:46
 * @Description：
 */
@Transactional
@Service(value = "HolidayService")
public class ProcessHolidayServiceImpl implements ProcessHolidayService {

    @Autowired
    ProcessHolidayMapper processHolidayMapper;

    @Autowired
    ApplyHolidayService applyHolidayService;

    /**
     * 获取查询结果总数
     * @param queryProcessHoliday
     * @return
     */
    @Override
    public long countTotal(ProcessHoliday queryProcessHoliday) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryProcessHoliday);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = processHolidayMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param processHoliday
     */
    @Override
    public void create(ProcessHoliday processHoliday) {
        processHolidayMapper.insert(processHoliday);
    }

    /**
     * 执行审核操作
     * @param processHoliday
     */
    @Override
    public void approve(ProcessHoliday processHoliday) {
        processHoliday.setApproveTime(new Date());
        processHolidayMapper.approve(processHoliday);
//        请假审核结果更新
        ApplyHoliday applyHoliday = new ApplyHoliday();
        applyHoliday.setId(processHoliday.getApplyId());
        applyHoliday.setResult(processHoliday.getResult());
        applyHolidayService.approve(applyHoliday);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public ProcessHoliday getOneById(Long id) {
        Map param = new HashMap();
        param.put("id", id);
        param.put("applyResultType", DictypeConstant.APPLY_RESULT_TYPE);
        return processHolidayMapper.getProcessHolidayById(param);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        processHolidayMapper.logicDeleteById(id);
    }

    /**
     * 获取查询结果
     * @param queryProcessHoliday
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ProcessHoliday> getHolidayProcesses(ProcessHoliday queryProcessHoliday, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryProcessHoliday);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        param.put("applyResultType", DictypeConstant.APPLY_RESULT_TYPE);
        return processHolidayMapper.getProcessHolidays(param);
    }

}
