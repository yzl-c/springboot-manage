package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.Holiday;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：假期Service
 */
public interface HolidayService {

    /**
     * 获取查询结果总数
     * @param queryHoliday
     * @return
     */
    long countTotal(Holiday queryHoliday);

    /**
     * 执行添加操作
     * @param holiday
     */
    void create(Holiday holiday);

    /**
     * 执行更新操作
     * @param holiday
     */
    void update(Holiday holiday);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Holiday getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 获取查询结果
     * @param queryHoliday
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Holiday> getHolidays(Holiday queryHoliday, Integer pageNum, Integer pageSize);

}
