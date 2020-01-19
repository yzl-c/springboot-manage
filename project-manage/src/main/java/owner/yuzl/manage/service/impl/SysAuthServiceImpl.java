package owner.yuzl.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owner.yuzl.manage.entity.po.SysAuthPO;
import owner.yuzl.manage.mapper.SysAuthMapper;
import owner.yuzl.manage.service.SysAuthService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 13:28
 * @Description：
 */
@Service
public class SysAuthServiceImpl implements SysAuthService {
    @Autowired
    SysAuthMapper sysAuthMapper;

    /**
     * 根据角色code查询权限
     * @param roleCode
     * @return
     */
    @Override
    public List<SysAuthPO> getAuthsByRoleCode(String roleCode) {
        return sysAuthMapper.getAuthsByRoleCode(roleCode);
    }
}
