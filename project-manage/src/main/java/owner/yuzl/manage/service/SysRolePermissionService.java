package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.entity.po.SysRolePO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/25 15:44
 * @Description：
 */
public interface SysRolePermissionService {
    List<SysPermissionPO> deleteRelativeById(Long roleId, Long permissionId);
}
