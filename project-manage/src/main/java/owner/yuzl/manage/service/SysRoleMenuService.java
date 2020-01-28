package owner.yuzl.manage.service;

/**
 * @Author：yzl_c
 * @Date：2020/1/25 15:44
 * @Description：
 */
public interface SysRoleMenuService {

    /**
     * 设置角色菜单
     * @param roleId
     * @param menuIds
     */
    void setRelative(Long roleId, String menuIds);
}
