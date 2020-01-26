package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysUserRolePO;

/**
 * @Author：yzl_c
 * @Date：2020/1/26 15:33
 * @Description：
 */
public interface SysUserRoleService {
    /**
     * 设置用户角色
     * @param sysUserRolePO
     */
    void setRelative(SysUserRolePO sysUserRolePO);
}
