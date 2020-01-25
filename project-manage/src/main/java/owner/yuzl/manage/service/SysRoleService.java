package owner.yuzl.manage.service;

import owner.yuzl.manage.entity.po.SysRolePO;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:27
 * @Description：
 */
public interface SysRoleService {
    /**
     * 获取查询结果总数
     * @param sysRolePO
     * @return
     */
    long countTotal(SysRolePO sysRolePO);

    /**
     * 根据用户账号查询角色
     * @param userAccount
     * @return
     */
    SysRolePO getRoleByUserAccount(String userAccount);

    /**
     * 查询角色列表
     * @param sysRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysRolePO> getRoleList(SysRolePO sysRole, Integer pageNum, Integer pageSize);

    /**
     * 执行添加操作
     * @param sysRole
     */
    void create(SysRolePO sysRole);

    /**
     * 执行更新操作
     * @param sysRole
     */
    void update(SysRolePO sysRole);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    SysRolePO getOneById(Long id);

    /**
     * 根据id逻辑删除
     * @param id
     */
    void logicDeleteById(Long id);
}
