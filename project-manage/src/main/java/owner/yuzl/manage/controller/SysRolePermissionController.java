package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.service.SysRolePermissionService;

import java.util.Map;

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

//    @Autowired
//    SysPermissionService sysPermissionService;

//    @RequestMapping(value = "/deleteRelativeById/{roleId}/{permissionId}", method = RequestMethod.DELETE)
//    public Result deleteRelative(@PathVariable("roleId") Long roleId, @PathVariable("permissionId") Long permissionId) {
//        List<SysPermissionPO> dataList = sysRolePermissionService.deleteRelativeById(roleId, permissionId);
//        return ResultFactory.buildSuccessResult(dataList, "解除关系成功");
//    }

    @RequestMapping(value = "/setRelative", method = RequestMethod.POST)
    public Result setRelative(@RequestBody Map<String, Object> param) {
        Integer roleId = (Integer) param.get("roleId");
        String permissionIds = (String) param.get("permissionIds");
        sysRolePermissionService.setRelative(roleId, permissionIds);
        return ResultFactory.buildSuccessResult(null, "权限设置成功");
    }
}
