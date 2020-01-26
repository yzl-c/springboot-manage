package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.entity.po.SysUserRolePO;
import owner.yuzl.manage.service.SysUserRoleService;

/**
 * @Author：yzl_c
 * @Date：2020/1/26 15:26
 * @Description：
 */
@RestController
@RequestMapping(value = "/sysUserRole")
public class SysUserRoleController {
    @Autowired
    SysUserRoleService sysUserRoleService;

    @RequestMapping(value = "/setRelative", method = RequestMethod.PUT)
    public Result setRelative(@RequestBody SysUserRolePO sysUserRole) {
        sysUserRoleService.setRelative(sysUserRole);
        return ResultFactory.buildSuccessResult(null, "角色设置成功");
    }
}
