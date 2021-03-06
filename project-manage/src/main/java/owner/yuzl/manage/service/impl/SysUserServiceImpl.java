package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.common.util.MapUtil;
import owner.yuzl.manage.entity.po.SysUserPO;
import owner.yuzl.manage.mapper.SysUserMapper;
import owner.yuzl.manage.mapper.SysUserRoleMapper;
import owner.yuzl.manage.service.SysRoleService;
import owner.yuzl.manage.service.SysUserService;

import java.util.*;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:46
 * @Description：
 */
@Transactional
@Service(value = "SysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    SysRoleService sysRoleService;

    /**
     * 获取查询结果总数
     * @param queryUser
     * @return
     */
    @Override
    public long countTotal(SysUserPO queryUser) {
//        SysUserPO sysUserPO = JSONObject.parseObject(search, SysUserPO.class);
//        if (ObjectUtils.isEmpty(sysUserPO)) {
//            sysUserPO = new SysUserPO();
//        }
//        sysUserPO.setDeleted(0);
//        //        匹配条件
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("deleted", ExampleMatcher.GenericPropertyMatchers.exact())
//                .withMatcher("account", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains());//全部模糊查询，即%{name}%
//        Example<SysUserPO> example = Example.of(sysUserPO, matcher);
//        Long countTotal = sysUserRepository.count(example);
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryUser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        Long countTotal = sysUserMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 执行添加操作
     * @param sysUserPO
     */
    @Override
    public void create(SysUserPO sysUserPO) {
        sysUserPO.setCreateTime(new Date());
        sysUserMapper.insert(sysUserPO);
    }

    /**
     * 执行更新操作
     * @param sysUserPO
     */
    @Override
    public void update(SysUserPO sysUserPO) {
        sysUserPO.setModifyTime(new Date());
        sysUserMapper.update(sysUserPO);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysUserPO getOneById(Long id) {
        return sysUserMapper.getUserById(id);
    }

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Override
    public void logicDeleteById(Long id) {
        sysUserMapper.logicDeleteById(id);
        sysUserRoleMapper.deleteRelativeByUserId(id);
    }

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    @Override
    public SysUserPO getUserByAccount(String account) {
        SysUserPO user = sysUserMapper.getUserByAccount(account);
        return user;
    }

    /**
     * 获取查询结果
     * @param queryUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysUserPO> getUsers(SysUserPO queryUser, Integer pageNum, Integer pageSize) {
        Map param = null;
        try {
            param = MapUtil.objectToMap(queryUser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Object 转换 Map 异常！");
        }
        if (!ObjectUtils.isEmpty(pageNum) && !ObjectUtils.isEmpty(pageSize)) {
            param.put("beginIndex", (pageNum - 1) * pageSize );
            param.put("pageSize", pageSize);
        }
        return sysUserMapper.getUsers(param);
    }

    /**
     * 查询account唯一性
     * @param account
     * @return
     */
    @Override
    public List<SysUserPO> checkAccountUnique(String account) {
        Map<String, Object> params = new HashMap<>();
        params.put("account", account);
        return sysUserMapper.getUsersByAccount(params);
    }
}
