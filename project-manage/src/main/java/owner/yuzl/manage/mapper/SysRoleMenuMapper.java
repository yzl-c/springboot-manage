package owner.yuzl.manage.mapper;


import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:49
 * @Description：
 */
public interface SysRoleMenuMapper {

    void deleteRelativeByRoleId(Long roleId);

    void createRelative(Long roleId, List<String> menuIds);

    void deleteRelativeByMenuIds(List<Long> menuIds);
}
