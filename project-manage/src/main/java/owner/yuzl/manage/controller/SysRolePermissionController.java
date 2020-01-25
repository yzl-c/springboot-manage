package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.service.SysPermissionService;
import owner.yuzl.manage.service.SysRolePermissionService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/25 15:43
 * @Description：
 */
@RestController
@RequestMapping(value = "/sysRolePermission")
public class SysRolePermissionController {
    @Autowired
    SysRolePermissionService sysRolePermissionService;

    @Autowired
    SysPermissionService sysPermissionService;

    @RequestMapping(value = "/deleteRelativeById/{roleId}/{permissionId}", method = RequestMethod.DELETE)
    public Result deleteRelative(@PathVariable("roleId") Long roleId, @PathVariable("permissionId") Long permissionId) {
        List<SysPermissionPO> dataList = sysRolePermissionService.deleteRelativeById(roleId, permissionId);
        return ResultFactory.buildSuccessResult(dataList, "解除关系成功");
    }
}
