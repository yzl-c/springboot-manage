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
     * 根据用户账号查询角色
     * @param userAccount
     * @return
     */
    SysRolePO getRoleByUserAccount(String userAccount);
}
