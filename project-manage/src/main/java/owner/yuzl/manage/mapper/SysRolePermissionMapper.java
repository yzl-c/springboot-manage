package owner.yuzl.manage.mapper;


import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:49
 * @Description：
 */
public interface SysRolePermissionMapper {

//    void deleteRelativeById(Long roleId, Long permissionId);

    void deleteRelativeByRoleId(Long roleId);

    void createRelative(Long roleId, List<String> permissionIds);

    void deleteRelativeByPermissionId(Long permissionId);
}
