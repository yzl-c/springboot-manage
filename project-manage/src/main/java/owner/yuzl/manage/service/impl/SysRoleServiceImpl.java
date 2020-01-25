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
import java.util.Date;
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
        List<SysPermissionPO> auths = sysPermissionService.getPermissionsByRoleId(role.getId());
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
            role.setPermissions(sysPermissionService.buildPermissionTree(allPermissions));
        }
        return roles;
    }

    /**
     * 执行添加操作
     * @param sysRole
     */
    @Override
    public void create(SysRolePO sysRole) {
        sysRole.setCreateTime(new Date());
        sysRoleMapper.insert(sysRole);
    }

    /**
     * 执行更新操作
     * @param sysRole
     */
    @Override
    public void update(SysRolePO sysRole) {
        sysRole.setModifyTime(new Date());
        sysRoleMapper.update(sysRole);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysRolePO getOneById(Long id) {
        return sysRoleMapper.getRoleById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysRoleMapper.logicDeleteById(id);
    }
}
