package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.mapper.SysRolePermissionMapper;
import owner.yuzl.manage.service.SysPermissionService;
import owner.yuzl.manage.service.SysRolePermissionService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/25 15:44
 * @Description：
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    SysPermissionService sysPermissionService;

    @Override
    public List<SysPermissionPO> deleteRelativeById(Long roleId, Long permissionId) {
        sysRolePermissionMapper.deleteRelativeById(roleId, permissionId);
        List<SysPermissionPO> list = sysPermissionService.getPermissionsByRoleId(roleId);
        List<SysPermissionPO> dataList = sysPermissionService.buildPermissionTree(list);
        return dataList;
    }
}
