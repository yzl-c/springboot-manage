package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.ProcessHoliday;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：家里流程Service
 */
public interface ProcessHolidayService {

    /**
     * 获取查询结果总数
     * @param queryProcessHoliday
     * @return
     */
    long countTotal(ProcessHoliday queryProcessHoliday);

    /**
     * 执行添加操作
     * @param processHoliday
     */
    void create(ProcessHoliday processHoliday);

    /**
     * 执行审核操作
     * @param processHoliday
     */
    void approve(ProcessHoliday processHoliday);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    ProcessHoliday getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 获取查询结果
     * @param queryProcessHoliday
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProcessHoliday> getHolidayProcesses(ProcessHoliday queryProcessHoliday, Integer pageNum, Integer pageSize);

}
