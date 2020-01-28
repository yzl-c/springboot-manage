package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.service.SysRoleMenuService;

import java.util.Map;

/**
 * @Author：yzl_c
 * @Date：2020/1/25 15:43
 * @Description：
 */
@RestController
@RequestMapping(value = "/sysRoleMenu")
public class SysRoleMenuController {
    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @RequestMapping(value = "/setRelative", method = RequestMethod.POST)
    public Result setRelative(@RequestBody Map<String, Object> param) {
        Integer roleId = (Integer) param.get("roleId");
        String menuIds = (String) param.get("menuIds");
        sysRoleMenuService.setRelative(roleId.longValue(), menuIds);
        return ResultFactory.buildSuccessResult(null, "菜单设置成功");
    }
}
