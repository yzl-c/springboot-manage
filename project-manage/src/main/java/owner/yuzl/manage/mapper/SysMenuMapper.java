package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysMenuPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:49
 * @Description：
 */
public interface SysMenuMapper {

    List<SysMenuPO> getAllMenus();
}
