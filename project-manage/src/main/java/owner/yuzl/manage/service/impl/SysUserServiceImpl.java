package owner.yuzl.manage.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import owner.yuzl.manage.entity.base.BasePage;
import owner.yuzl.manage.entity.po.SysUserPO;
import owner.yuzl.manage.mapper.SysUserMapper;
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
        return sysUserMapper.getPage(param);
    }

    @Override
    public void create(SysUserPO sysUserPO) {
        sysUserMapper.create(sysUserPO);
    }
}
