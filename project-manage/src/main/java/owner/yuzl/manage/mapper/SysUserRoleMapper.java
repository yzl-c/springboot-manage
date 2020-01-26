package owner.yuzl.manage.mapper;


import owner.yuzl.manage.entity.po.SysUserRolePO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/26 18:49
 * @Description：
 */
public interface SysUserRoleMapper {

    void deleteRelativeByUserId(SysUserRolePO sysUserRole);

    void createRelative(SysUserRolePO sysUserRole);
}
