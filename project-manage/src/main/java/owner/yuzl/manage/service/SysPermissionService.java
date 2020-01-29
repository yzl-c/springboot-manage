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
     * 根据等级查询权限
     * @param level
     * @return
     */
    List<SysPermissionPO> getPermissionsByLevel(Integer level);

    /**
     * 根据角色id查询权限
     * @param id
     * @return
     */
    List<SysPermissionPO> getPermissionsByRoleId(Long id);

    /**
     * 获取所有权限列表
     * @param
     * @return
     */
    List<SysPermissionPO> getPermissionsList(SysPermissionPO sysPermission, Integer pageNum, Integer pageSize);

    /**
     * 获取权限列表（树结构）
     * @return
     */
    List<SysPermissionPO> getPermissionsTree();

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

    /**
     * 构建权限树
     * @param allPermissions
     * @return
     */
    List<SysPermissionPO> buildPermissionTree(List<SysPermissionPO> allPermissions);

    /**
     * 获取子权限
     * @param id 父权限id
     * @param allPermissions 所有权限列表
     * @return 每个父权限下，所有子权限列表
     */
    List<SysPermissionPO> getSubPermissions(Long id, List<SysPermissionPO> allPermissions);

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    List<SysPermissionPO> checkCodeUnique(String code);
}
