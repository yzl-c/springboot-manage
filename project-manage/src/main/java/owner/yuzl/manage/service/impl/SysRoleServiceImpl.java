package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.mapper.SysRoleMapper;
import owner.yuzl.manage.service.SysPermissionService;
import owner.yuzl.manage.service.SysRoleService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:27
 * @Description：
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysPermissionService sysPermissionService;

    /**
     * 根据用户账号查询角色
     * @param userAccount
     * @return
     */
    @Override
    public SysRolePO getRoleByUserAccount(String userAccount) {
        SysRolePO role = sysRoleMapper.getRoleByUserAccount(userAccount);
        List<SysPermissionPO> auths = sysPermissionService.getPermissionsByRoleCode(role.getCode());
        role.setPermissions(auths);
        return role;
    }
}
