package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.ApplyHoliday;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：假期Service
 */
public interface ApplyHolidayService {

    /**
     * 获取查询结果总数
     * @param queryApplyHoliday
     * @return
     */
    long countTotal(ApplyHoliday queryApplyHoliday);

    /**
     * 执行添加操作
     * @param applyHoliday
     */
    void create(ApplyHoliday applyHoliday);

    /**
     * 执行更新操作
     * @param applyHoliday
     */
    void update(ApplyHoliday applyHoliday);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    ApplyHoliday getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 获取查询结果
     * @param queryApplyHoliday
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ApplyHoliday> getHolidays(ApplyHoliday queryApplyHoliday, Integer pageNum, Integer pageSize);

    /**
     * 请假申请审核
     * @param applyHoliday
     */
    void approve(ApplyHoliday applyHoliday);
}
