package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.entity.po.SysMenuPO;
import owner.yuzl.manage.mapper.SysMenuMapper;
import owner.yuzl.manage.service.SysMenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:47
 * @Description：
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    /**
     * 构建左侧菜单栏
     * @return 菜单列表
     */
    @Override
    public List<SysMenuPO> bulidAsideMenu() {
        List<SysMenuPO> allMenus = sysMenuMapper.getAllMenus();

        // 获取一级菜单
        List<SysMenuPO> rootMenus = new ArrayList<>();
        for (SysMenuPO menu : allMenus) {
            // 父节点是0的，为一级菜单
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
     * 获取子节点
     * @param id 父节点id
     * @param allMenus 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<SysMenuPO> getSubMenus(Long id, List<SysMenuPO> allMenus){
        //子菜单
        List<SysMenuPO> subMenuList = new ArrayList<>();
        for (SysMenuPO menu : allMenus) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(menu.getParentId().equals(id)){
                subMenuList.add(menu);
            }
        }
        //递归
        for (SysMenuPO menu : subMenuList) {
            menu.setSubMenus(getSubMenus(menu.getId(), allMenus));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(subMenuList.size() == 0){
            return new ArrayList<>();
        }
        return subMenuList;
    }
}
