package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.mapper.SysRoleMapper;
import owner.yuzl.manage.service.SysPermissionService;
import owner.yuzl.manage.service.SysRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:27
 * @Description：
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysPermissionService sysPermissionService;

    @Override
    public long countTotal(SysRolePO sysRolePO) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysRolePO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysRoleMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 根据用户账号查询角色
     * @param userAccount
     * @return
     */
    @Override
    public SysRolePO getRoleByUserAccount(String userAccount) {
        SysRolePO role = sysRoleMapper.getRoleByUserAccount(userAccount);
        List<SysPermissionPO> auths = sysPermissionService.getPermissionsByRoleCode(role.getCode());
        role.setPermissions(auths);
        return role;
    }

    /**
     * 查询角色列表
     * @param sysRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysRolePO> getRoleList(SysRolePO sysRole, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysRole);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        param.put("beginIndex", (pageNum - 1) * pageSize );
        param.put("pageSize", pageSize);
        List<SysRolePO> roles = sysRoleMapper.getRolesList(param);
        for (SysRolePO role : roles) {
            List<SysPermissionPO> allPermissions = role.getPermissions();
            role.setPermissions(buildPermissionTree(allPermissions));
        }
        return roles;
    }

    public List<SysPermissionPO> buildPermissionTree(List<SysPermissionPO> allPermissions) {
        // 构建权限树
        List<SysPermissionPO> rootPermissions = new ArrayList<>();
        // 首先添加一级权限
        for (SysPermissionPO permission : allPermissions) {
            if(permission.getParentId() == 0){
                rootPermissions.add(permission);
            }
        }
        // 设置子权限
        for (SysPermissionPO permission : rootPermissions) {
            List<SysPermissionPO> subPermissions = getSubPermissions(permission.getId(), allPermissions);
            permission.setSubPermissions(subPermissions);
        }
        return rootPermissions;
    }

    /**
     * 获取子权限
     * @param id 父权限id
     * @param allPermissions 所有权限列表
     * @return 每个父权限下，所有子权限列表
     */
    public List<SysPermissionPO> getSubPermissions(Long id, List<SysPermissionPO> allPermissions){
        //子菜单
        List<SysPermissionPO> subPermissionList = new ArrayList<>();
        for (SysPermissionPO permission : allPermissions) {
            // 遍历所有权限，将所有权限的父id与传过来的赋权限的id比较。相等说明：为该父节点的子节点。
            if(permission.getParentId().equals(id)){
                subPermissionList.add(permission);
            }
        }
        //递归
        for (SysPermissionPO permission : subPermissionList) {
            permission.setSubPermissions(getSubPermissions(permission.getId(), allPermissions));
        }
        //如果权限下没有子权限，返回一个空List（递归退出）
        if(subPermissionList.size() == 0){
            return new ArrayList<>();
        }
        return subPermissionList;
    }
}
