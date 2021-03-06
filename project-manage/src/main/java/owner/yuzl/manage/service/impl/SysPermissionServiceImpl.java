package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.mapper.SysPermissionMapper;
import owner.yuzl.manage.mapper.SysRolePermissionMapper;
import owner.yuzl.manage.service.SysPermissionService;

import java.util.*;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:28
 * @Description：
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 根据等级查询权限
     * @param level
     * @return
     */
    @Override
    public List<SysPermissionPO> getPermissionsByLevel(Integer level) {
        Map<String, Object> params = new HashMap<>();
        params.put("level", level);
        return sysPermissionMapper.getPermissions(params);
    }

    /**
     * 查询code唯一性
     * @param code
     * @return
     */
    @Override
    public List<SysPermissionPO> checkCodeUnique(String code) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        return sysPermissionMapper.getPermissionsByCode(params);
    }

    /**
     * 根据角色id查询权限
     * @param roleId
     * @return
     */
    @Override
    public List<SysPermissionPO> getPermissionsByRoleId(Long roleId) {
        return sysPermissionMapper.getPermissionsByRoleId(roleId);
    }

    /**
     *
     * @param sysPermission
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysPermissionPO> getPermissionsList(SysPermissionPO sysPermission, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysPermission);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        return sysPermissionMapper.getPermissions(param);
    }

    /**
     * 获取权限列表（树结构）
     * @return
     */
    @Override
    public List<SysPermissionPO> getPermissionsTree() {
        List<SysPermissionPO> allPermissions = sysPermissionMapper.getPermissions(null);
        List<SysPermissionPO> dataList = buildPermissionTree(allPermissions);
        return dataList;
    }

    /**
     * 获取查询结果总数
     * @param sysPermission
     * @return
     */
    @Override
    public long countTotal(SysPermissionPO sysPermission) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(sysPermission);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysPermissionMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param sysPermission
     */
    @Override
    public void create(SysPermissionPO sysPermission) {
        sysPermission.setCreateTime(new Date());
        sysPermissionMapper.insert(sysPermission);
    }

    /**
     * 执行更新操作
     * @param sysPermission
     */
    @Override
    public void update(SysPermissionPO sysPermission) {
        sysPermission.setModifyTime(new Date());
        sysPermissionMapper.update(sysPermission);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysPermissionPO getOneById(Long id) {
        return sysPermissionMapper.getPermissionById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysPermissionMapper.logicDeleteById(id);
        // 删除角色权限关系
        sysRolePermissionMapper.deleteRelativeByPermissionId(id);
    }

    /**
     * 构建权限树
     * @param allPermissions
     * @return
     */
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
