package owner.yuzl.manage.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import owner.yuzl.manage.entity.base.BasePage;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.entity.po.SysUserPO;
import owner.yuzl.manage.mapper.SysUserMapper;
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
    SysRoleService sysRoleService;

    /**
     * 获取查询结果总数
     * @param search
     * @return
     */
    @Override
    public long countTotal(String search) {
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
        Map param = JSON.parseObject(search);
        if (ObjectUtils.isEmpty(param)) {
            param = new HashMap();
        }
        Long countTotal = sysUserMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    /**
     * 获取查询结果
     * @param search
     * @param page
     * @return
     */
    @Override
    public List<SysUserPO> getPage(String search, BasePage page) {
//        springdatajpa方式
//        SysUserPO sysUserPO = JSONObject.parseObject(search, SysUserPO.class);
//        if (ObjectUtils.isEmpty(sysUserPO)) {
//            sysUserPO = new SysUserPO();
//        }
//        sysUserPO.setDeleted(0);
////        SpringDataJpa操作
////        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");  //排序
//        Pageable pageable = PageRequest.of(page.getCurrentPage() - 1, page.getPageSize()); // 分页
////        匹配条件
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("deleted", ExampleMatcher.GenericPropertyMatchers.exact())
//                .withMatcher("account", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains());//全部模糊查询，即%{name}%
//        Example<SysUserPO> example = Example.of(sysUserPO, matcher);
//        Page<SysUserPO> resultPage = sysUserRepository.findAll(example, pageable);
        //        Mybatis方式
        Map param = JSON.parseObject(search);
        if (ObjectUtils.isEmpty(param)) {
            param = new HashMap();
        }

        param.put("currentBeginIndex", page.getCurrentBeginIndex());
        param.put("pageSize", page.getPageSize());
        return sysUserMapper.getPage(param);
    }

    /**
     * 执行更新操作
     * @param sysUserPO
     */
    @Override
    public void update(SysUserPO sysUserPO) {
        if (StringUtils.isEmpty(sysUserPO.getId())) {
            sysUserPO.setCreateTime(new Date());
            sysUserMapper.insert(sysUserPO);
        } else {
            sysUserPO.setModifyTime(new Date());
            sysUserMapper.update(sysUserPO);
        }
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public SysUserPO getOneById(Long id) {
        return null;
    }

    /**
     * 根据ids（单个或多个id）逻辑删除
     * @param ids
     */
    @Override
    public void logicDelete(String ids) {
        sysUserMapper.logicDelete(Arrays.asList(ids.split(",")));
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
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysUserPO> getUsers(String query, Integer pageNum, Integer pageSize) {
        Map param = JSON.parseObject(query);
        if (ObjectUtils.isEmpty(param)) {
            param = new HashMap();
        }

        param.put("beginIndex", (pageNum - 1) * pageSize );
        param.put("pageSize", pageSize);
        return sysUserMapper.getUsers(param);
    }
}
