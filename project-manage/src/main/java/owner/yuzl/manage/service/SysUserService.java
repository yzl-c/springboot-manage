package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.base.BasePage;
import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2019/12/22 14:45
 * @Description：
 */
public interface SysUserService {

    int countTotal(String search);

    List<SysUserPO> getPage(String search, BasePage page);

    void update(SysUserPO sysUserPO);

    SysUserPO getOneById(Long id);
}
