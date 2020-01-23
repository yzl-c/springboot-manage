package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysPermissionPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:27
 * @Description：
 */
public interface SysPermissionService {
    /**
     * 根据角色code查询权限
     * @param roleCode
     * @return
     */
    List<SysPermissionPO> getPermissionsByRoleCode(String roleCode);

    /**
     * 获取所有权限列表
     * @param
     * @return
     */
    List<SysPermissionPO> getPermissionsList(SysPermissionPO sysPermission, Integer pageNum, Integer pageSize);

    /**
     * 获取查询结果总数
     * @param sysPermission
     * @return
     */
    long countTotal(SysPermissionPO sysPermission);

    /**
     * 执行添加操作
     * @param sysPermission
     */
    void create(SysPermissionPO sysPermission);

    /**
     * 执行更新操作
     * @param sysPermission
     */
    void update(SysPermissionPO sysPermission);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysPermissionPO getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);
}
