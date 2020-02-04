package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.base.DictypeConstant;
import owner.yuzl.manage.entity.po.ApplyHoliday;
import owner.yuzl.manage.entity.po.ProcessHoliday;
import owner.yuzl.manage.mapper.ApplyHolidayMapper;
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
@Service
public class ApplyHolidayServiceImpl implements ApplyHolidayService {

    @Autowired
    ApplyHolidayMapper applyHolidayMapper;

    @Autowired
    ProcessHolidayService processHolidayService;

    /**
     * 获取查询结果总数
     * @param queryApplyHoliday
     * @return
     */
    @Override
    public long countTotal(ApplyHoliday queryApplyHoliday) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryApplyHoliday);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = applyHolidayMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param applyHoliday
     */
    @Override
    public void create(ApplyHoliday applyHoliday) {
        applyHoliday.setCreateTime(new Date());
        applyHolidayMapper.insert(applyHoliday);
        // 添加请假流程
        ProcessHoliday processHoliday = new ProcessHoliday();
        processHoliday.setApplyId(applyHoliday.getId());
        processHoliday.setApplyTime(applyHoliday.getCreateTime());
        processHoliday.setApplyUser(applyHoliday.getCreateUser());
        processHolidayService.create(processHoliday);
    }

    /**
     * 执行更新操作
     * @param applyHoliday
     */
    @Override
    public void update(ApplyHoliday applyHoliday) {
        applyHoliday.setModifyTime(new Date());
        applyHolidayMapper.update(applyHoliday);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public ApplyHoliday getOneById(Long id) {
        Map<String, Object> param = new HashMap();
        param.put("id", id);
        param.put("holidayType", DictypeConstant.HOLIDAY_TYPE);
        param.put("applyStatusType", DictypeConstant.APPLY_STATUS_TYPE);
        param.put("applyResultType", DictypeConstant.APPLY_RESULT_TYPE);
        return applyHolidayMapper.getApplyHolidayById(param);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        applyHolidayMapper.logicDeleteById(id);
    }

    /**
     * 获取查询结果
     * @param queryApplyHoliday
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ApplyHoliday> getHolidays(ApplyHoliday queryApplyHoliday, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryApplyHoliday);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        param.put("holidayType", DictypeConstant.HOLIDAY_TYPE);
        param.put("applyStatusType", DictypeConstant.APPLY_STATUS_TYPE);
        param.put("applyResultType", DictypeConstant.APPLY_RESULT_TYPE);
        return applyHolidayMapper.getApplyHolidays(param);
    }

    /**
     * 请假申请审核
     * @param applyHoliday
     */
    @Override
    public void approve(ApplyHoliday applyHoliday) {
        applyHolidayMapper.approve(applyHoliday);
    }
}
