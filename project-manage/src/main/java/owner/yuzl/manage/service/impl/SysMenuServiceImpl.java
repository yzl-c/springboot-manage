package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysMenuPO;
import owner.yuzl.manage.mapper.SysMenuMapper;
import owner.yuzl.manage.mapper.SysRoleMenuMapper;
import owner.yuzl.manage.service.SysMenuService;

import java.util.*;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:47
 * @Description：
 */
@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 获取菜单列表
     * @param sysMenu
     * @return
     */
    @Override
    public List<SysMenuPO> getMenusList(SysMenuPO sysMenu) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysMenu);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        return this.bulidAsideMenu(sysMenuMapper.getMenus(param));
    }

    /**
     * 获取所有左侧菜单列表
     * @return
     */
    @Override
    public List<SysMenuPO> getAllMenus() {
        List<SysMenuPO> menus = sysMenuMapper.getAllMenus();
        return this.bulidAsideMenu(menus);
    }

    /**
     * 获取查询结果总数
     * @param sysMenu
     * @return
     */
    @Override
    public long countTotal(SysMenuPO sysMenu) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysMenu);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysMenuMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param sysMenu
     */
    @Override
    public void create(SysMenuPO sysMenu) {
        sysMenu.setCreateTime(new Date());
        sysMenuMapper.insert(sysMenu);
    }

    /**
     * 执行更新操作
     * @param sysMenu
     */
    @Override
    public void update(SysMenuPO sysMenu) {
        sysMenu.setModifyTime(new Date());
        sysMenuMapper.update(sysMenu);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysMenuPO getOneById(Long id) {
        return sysMenuMapper.getMenuById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        SysMenuPO deletedMenu = this.getOneById(id);
        sysMenuMapper.logicDeleteById(id);
        List<Long> menuIds = new ArrayList<>();
        menuIds.add(id);
        if (deletedMenu.getParentId() == 0) {
            List<SysMenuPO> list = new ArrayList<>();
            list = sysMenuMapper.getMenusByParentId(id);
            if (list.size() > 0) {
                for (SysMenuPO menu : list) {
                    menuIds.add(menu.getId());
                }
            }
            sysMenuMapper.logicDeleteByParentId(id);
        }
        // 删除角色菜单关系
        sysRoleMenuMapper.deleteRelativeByMenuIds(menuIds);
    }
    
    /**
     * 构建左侧菜单栏
     * @return 菜单列表
     */
    @Override
    public List<SysMenuPO> bulidAsideMenu(List<SysMenuPO> menus) {
        List<SysMenuPO> allMenus = menus;

        // 获取一级菜单
        List<SysMenuPO> rootMenus = new ArrayList<>();
        for (SysMenuPO menu : allMenus) {
            // 父菜单是0的，为一级菜单
            if(menu.getParentId() == 0){
                rootMenus.add(menu);
            }
        }
        // 设置子菜单
        for (SysMenuPO menu : rootMenus) {
            List<SysMenuPO> subMenus = getSubMenus(menu.getId(), allMenus);
            menu.setSubMenus(subMenus);
        }
        return rootMenus;
    }

    /**
     * 获取子菜单
     * @param id 父菜单id
     * @param allMenus 所有菜单列表
     * @return 每个根菜单下，所有子菜单列表
     */
    public List<SysMenuPO> getSubMenus(Long id, List<SysMenuPO> allMenus){
        //子菜单
        List<SysMenuPO> subMenuList = new ArrayList<>();
        for (SysMenuPO menu : allMenus) {
            // 遍历所有菜单，将所有菜单的父id与传过来的根菜单的id比较
            //相等说明：为该根菜单的子菜单。
            if(menu.getParentId().equals(id)){
                subMenuList.add(menu);
            }
        }
        //递归
        for (SysMenuPO menu : subMenuList) {
            menu.setSubMenus(getSubMenus(menu.getId(), allMenus));
        }
        //如果菜单下没有子菜单，返回一个空List（递归退出）
        if(subMenuList.size() == 0){
            return new ArrayList<>();
        }
        return subMenuList;
    }

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    @Override
    public List<SysMenuPO> checkCodeUnique(String code) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        return sysMenuMapper.getMenusByCode(params);
    }
}
