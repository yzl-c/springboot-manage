package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owner.yuzl.manage.mapper.SysRoleMenuMapper;
import owner.yuzl.manage.service.SysMenuService;
import owner.yuzl.manage.service.SysRoleMenuService;

import java.util.Arrays;
import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/25 15:44
 * @Description：
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    SysMenuService sysMenuService;

    /**
     * 设置角色菜单
     * @param roleId
     * @param menuIds
     */
    @Override
    @Transactional
    public void setRelative(Long roleId, String menuIds) {
        sysRoleMenuMapper.deleteRelativeByRoleId(roleId);
        List<String> ids = Arrays.asList(menuIds.split(","));
        sysRoleMenuMapper.createRelative(roleId, ids);
    }
}
