package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:30
 * @Description：
 */
public interface SysUserMapper {
    List<SysUserPO> getPage(Map param);

    void insert(SysUserPO sysUserPO);

    Long countTotal(Map param);

    void update(SysUserPO sysUserPO);

    void logicDelete(List ids);

    SysUserPO getUserByAccount(String account);

    List<SysUserPO> getUsers(Map param);
}
