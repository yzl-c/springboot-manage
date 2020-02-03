package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.Holiday;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface HolidayMapper {

    Long countTotal(Map param);

    void insert(Holiday holiday);

    void update(Holiday holiday);

    void logicDeleteById(Long id);

    List<Holiday> getHolidays(Map param);

    Holiday getHolidayById(Long id);

}
