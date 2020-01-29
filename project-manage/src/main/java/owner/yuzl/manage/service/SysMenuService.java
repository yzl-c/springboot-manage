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
    List<SysMenuPO> bulidAsideMenu(List<SysMenuPO> menus);

    /**
     * 获取菜单列表
     * @param
     * @return
     */
    List<SysMenuPO> getMenusList(SysMenuPO sysMenu);

    /**
     * 获取所有菜单列表
     * @param
     * @return
     */
    List<SysMenuPO> getAllMenus();


    /**
     * 获取查询结果总数
     * @param sysMenu
     * @return
     */
    long countTotal(SysMenuPO sysMenu);

    /**
     * 执行添加操作
     * @param sysMenu
     */
    void create(SysMenuPO sysMenu);

    /**
     * 执行更新操作
     * @param sysMenu
     */
    void update(SysMenuPO sysMenu);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysMenuPO getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    List<SysMenuPO> checkCodeUnique(String code);
}
