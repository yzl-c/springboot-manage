package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysDepartmentPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：系统用户Service
 */
public interface SysDepartmentService {

    /**
     * 获取查询结果总数
     * @param queryDepartment
     * @return
     */
    long countTotal(SysDepartmentPO queryDepartment);

    /**
     * 执行添加操作
     * @param sysDepartmentPO
     */
    void create(SysDepartmentPO sysDepartmentPO);

    /**
     * 执行更新操作
     * @param sysDepartmentPO
     */
    void update(SysDepartmentPO sysDepartmentPO);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysDepartmentPO getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 获取查询结果
     * @param queryDepartment
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysDepartmentPO> getDepartments(SysDepartmentPO queryDepartment, Integer pageNum, Integer pageSize);

}
