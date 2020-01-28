package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owner.yuzl.manage.entity.po.SysUserRolePO;
import owner.yuzl.manage.mapper.SysUserRoleMapper;
import owner.yuzl.manage.service.SysUserRoleService;

/**
 * @Author：yzl_c
 * @Date：2020/1/26 15:33
 * @Description：
 */
@Service
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    /**
     * 设置用户角色
     * @param sysUserRole
     */
    @Override
    public void setRelative(SysUserRolePO sysUserRole) {
        sysUserRoleMapper.deleteRelativeByUserId(sysUserRole.getUserId());
        sysUserRoleMapper.createRelative(sysUserRole);
    }
}
