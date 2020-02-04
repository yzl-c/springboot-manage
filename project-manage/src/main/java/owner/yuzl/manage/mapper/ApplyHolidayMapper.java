package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.ApplyHoliday;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface ApplyHolidayMapper {

    Long countTotal(Map param);

    void insert(ApplyHoliday applyHoliday);

    void update(ApplyHoliday applyHoliday);

    void logicDeleteById(Long id);

    List<ApplyHoliday> getApplyHolidays(Map param);

    ApplyHoliday getApplyHolidayById(Map param);

    void approve(ApplyHoliday applyHoliday);
}
