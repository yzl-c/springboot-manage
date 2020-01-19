package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.base.BasePage;
import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：系统用户Service
 */
public interface SysUserService {

    /**
     * 获取查询结果总数
     * @param search
     * @return
     */
    long countTotal(String search);

    /**
     * 获取查询结果
     * @param search
     * @param page
     * @return
     */
    List<SysUserPO> getPage(String search, BasePage page);

    /**
     * 执行更新操作
     * @param sysUserPO
     */
    void update(SysUserPO sysUserPO);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysUserPO getOneById(Long id);

    /**
     * 根据ids逻辑删除
     * @param ids
     */
    void logicDelete(String ids);

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    SysUserPO getUserByAccount(String account);
}
