package owner.yuzl.manage.service;

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
     * @param queryUser
     * @return
     */
    long countTotal(SysUserPO queryUser);

    /**
     * 执行添加操作
     * @param sysUserPO
     */
    void create(SysUserPO sysUserPO);

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
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    SysUserPO getUserByAccount(String account);

    /**
     * 获取查询结果
     * @param queryUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysUserPO> getUsers(SysUserPO queryUser, Integer pageNum, Integer pageSize);

    /**
     * 查询account唯一性
     * @param account
     * @return
     */
    List<SysUserPO> checkAccountUnique(String account);
}
