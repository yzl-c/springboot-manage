package owner.yuzl.manage.common.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import owner.yuzl.manage.entity.po.SysAuthPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.entity.po.SysUserPO;
import owner.yuzl.manage.service.SysUserService;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 20:13
 * @Description：
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    /**
     * 授予角色权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入授权方法，进行授权");
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUserPO user = (SysUserPO) principalCollection.getPrimaryPrincipal();
        Set<SysAuthPO> permissions = new HashSet<>();
        //添加角色
        SysRolePO role = user.getRole();
        simpleAuthorizationInfo.addRole(role.getCode());
        for (SysAuthPO permission : role.getPermissions()) {
            permissions.add(permission);
        }
        //添加权限
        for (SysAuthPO permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission.getCode());
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        SysUserPO user = sysUserService.getUserByAccount(usernamePasswordToken.getUsername());
        return new SimpleAuthenticationInfo(user, user.getPassword(), "") ;
    }

}
