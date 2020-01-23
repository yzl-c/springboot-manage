package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysPermissionPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface SysPermissionMapper {
    List<SysPermissionPO> getPermissionsByRoleCode(String roleCode);

    List<SysPermissionPO> getPermissions(Map param);

    Long countTotal(Map param);

    void insert(SysPermissionPO sysPermission);

    void update(SysPermissionPO sysPermission);

    void logicDeleteById(Long id);

    SysPermissionPO getUserById(Long id);
}
