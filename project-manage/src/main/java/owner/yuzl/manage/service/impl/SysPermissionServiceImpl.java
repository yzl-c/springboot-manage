package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.mapper.SysPermissionMapper;
import owner.yuzl.manage.service.SysPermissionService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:28
 * @Description：
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    SysPermissionMapper sysPermissionMapper;

    /**
     * 根据角色code查询权限
     * @param roleCode
     * @return
     */
    @
    Override
    public List<SysPermissionPO> getPermissionsByRoleCode(String roleCode) {
        return sysPermissionMapper.getPermissionsByRoleCode(roleCode);
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
        param.put("beginIndex", (pageNum - 1) * pageSize );
        param.put("pageSize", pageSize);
        return sysPermissionMapper.getPermissions(param);
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
        return sysPermissionMapper.getUserById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysPermissionMapper.logicDeleteById(id);
    }
}
