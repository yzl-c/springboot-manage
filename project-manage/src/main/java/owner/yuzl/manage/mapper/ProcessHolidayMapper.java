package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.ProcessHoliday;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface ProcessHolidayMapper {

    Long countTotal(Map param);

    void insert(ProcessHoliday processHoliday);

    void approve(ProcessHoliday processHoliday);

    void logicDeleteById(Long id);

    List<ProcessHoliday> getProcessHolidays(Map param);

    ProcessHoliday getProcessHolidayById(Map param);

}
