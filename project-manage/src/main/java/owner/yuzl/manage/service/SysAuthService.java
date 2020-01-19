package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysAuthPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:27
 * @Description：
 */
public interface SysAuthService {
    /**
     * 根据角色code查询权限
     * @param roleCode
     * @return
     */
    List<SysAuthPO> getAuthsByRoleCode(String roleCode);
}
