package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.base.DictypeConstant;
import owner.yuzl.manage.entity.po.Holiday;
import owner.yuzl.manage.mapper.HolidayMapper;
import owner.yuzl.manage.service.HolidayService;
import owner.yuzl.manage.service.SysRoleService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:46
 * @Description：
 */
@Transactional
@Service(value = "HolidayService")
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    HolidayMapper holidayMapper;

    /**
     * 获取查询结果总数
     * @param queryHoliday
     * @return
     */
    @Override
    public long countTotal(Holiday queryHoliday) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryHoliday);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = holidayMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param holiday
     */
    @Override
    public void create(Holiday holiday) {
        holiday.setCreateTime(new Date());
        holidayMapper.insert(holiday);
    }

    /**
     * 执行更新操作
     * @param holiday
     */
    @Override
    public void update(Holiday holiday) {
        holiday.setModifyTime(new Date());
        holidayMapper.update(holiday);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public Holiday getOneById(Long id) {
        return holidayMapper.getHolidayById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        holidayMapper.logicDeleteById(id);
    }

    /**
     * 获取查询结果
     * @param queryHoliday
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Holiday> getHolidays(Holiday queryHoliday, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryHoliday);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        param.put("holidayType", DictypeConstant.HOLIDAY_TYPE);
        return holidayMapper.getHolidays(param);
    }

}
