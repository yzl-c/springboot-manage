package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.entity.po.SysAuthPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.mapper.SysRoleMapper;
import owner.yuzl.manage.service.SysAuthService;
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
    SysAuthService sysAuthService;

    /**
     * 根据用户账号查询角色
     * @param userAccount
     * @return
     */
    @Override
    public List<SysRolePO> getRolesByUserAccount(String userAccount) {
        List<SysRolePO> roles = sysRoleMapper.getRolesByUserAccount(userAccount);
        for (SysRolePO role : roles) {
            List<SysAuthPO> auths = sysAuthService.getAuthsByRoleCode(role.getCode());
            role.setPermissions(auths);
        }
        return roles;
    }
}
