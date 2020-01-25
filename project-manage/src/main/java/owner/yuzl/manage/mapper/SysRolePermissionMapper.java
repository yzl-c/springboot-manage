package owner.yuzl.manage.mapper;


/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:49
 * @Description：
 */
public interface SysRolePermissionMapper {

    void deleteRelativeById(Long roleId, Long permissionId);
}
