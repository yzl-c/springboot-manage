package owner.yuzl.manage.mapper;

import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2019/12/22 16:30
 * @Description：
 */
public interface SysUserMapper {
    List<SysUserPO> getPage(Map param);

    void create(SysUserPO sysUserPO);

    int countTotal(Map param);
}
