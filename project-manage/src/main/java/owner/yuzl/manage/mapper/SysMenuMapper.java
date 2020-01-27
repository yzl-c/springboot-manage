package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysMenuPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:49
 * @Description：
 */
public interface SysMenuMapper {
    List<SysMenuPO> getAllMenus();

    List<SysMenuPO> getMenus(Map param);

    Long countTotal(Map param);

    void insert(SysMenuPO sysMenu);

    void update(SysMenuPO sysMenu);

    void logicDeleteById(Long id);

    SysMenuPO getMenuById(Long id);

    void logicDeleteByParentId(Long parentId);
}
