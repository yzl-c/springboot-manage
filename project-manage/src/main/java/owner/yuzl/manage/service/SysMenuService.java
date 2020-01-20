package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysMenuPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:46
 * @Description：
 */
public interface SysMenuService {
    /**
     * 构建左侧菜单栏
     * @return 菜单列表
     */
    List<SysMenuPO> bulidAsideMenu();
}
