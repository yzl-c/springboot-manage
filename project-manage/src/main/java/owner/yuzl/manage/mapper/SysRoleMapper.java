package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface SysRoleMapper {
    List<SysRolePO> getRolesByUserAccount(String userAccount);
}
