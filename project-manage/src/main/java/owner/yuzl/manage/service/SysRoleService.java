package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysRolePO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:27
 * @Description：
 */
public interface SysRoleService {
    /**
     * 获取查询结果总数
     * @param sysPermission
     * @return
     */
    long countTotal(SysRolePO sysRolePO);

    /**
     * 根据用户账号查询角色
     * @param userAccount
     * @return
     */
    SysRolePO getRoleByUserAccount(String userAccount);

    /**
     * 查询角色列表
     * @param sysRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysRolePO> getRoleList(SysRolePO sysRole, Integer pageNum, Integer pageSize);
}
