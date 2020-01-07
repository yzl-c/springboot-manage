package owner.yuzl.manage.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.entity.base.BasePage;
import owner.yuzl.manage.entity.po.SysUserPO;
import owner.yuzl.manage.mapper.SysUserMapper;
import owner.yuzl.manage.repository.SysUserRepository;
import owner.yuzl.manage.service.SysUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2019/12/22 14:46
 * @Description：
 */
@Service(value = "SysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public int countTotal(String search) {
        Map param = JSON.parseObject(search);
        if (ObjectUtils.isEmpty(param)) {
            param = new HashMap();
        }
        Integer countTotal = sysUserMapper.countTotal(param);
        return countTotal == null ? 0 : countTotal;
    }

    @Override
    public List<SysUserPO> getPage(String search, BasePage page) {
        Map param = JSON.parseObject(search);
        if (ObjectUtils.isEmpty(param)) {
            param = new HashMap();
        }

        param.put("currentBeginIndex", page.getCurrentBeginIndex());
        param.put("pageSize", page.getPageSize());
//        SpringDataJpa操作
//        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
//        Pageable pageable = PageRequest.of(0, 10, sort);
//        Page result = sysUserRepository.findSysUserPOSByAccountAndName((String)param.get("account"), (String)param.get("name"), pageable);
        return sysUserMapper.getPage(param);
    }

    @Override
    public void create(SysUserPO sysUserPO) {
        sysUserRepository.save(sysUserPO);
    }
}
