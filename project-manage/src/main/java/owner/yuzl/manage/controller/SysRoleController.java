package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.SysMenuPO;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.entity.po.SysRolePO;
import owner.yuzl.manage.service.SysMenuService;
import owner.yuzl.manage.service.SysRoleService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:21
 * @Description：系统角色Controller
 */
@RestController
@RequestMapping(value = "/sysRole")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;

    /**
     * 查询角色列表
     * @param sysRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getRolesList", method = RequestMethod.GET)
    public Result getRolesList(SysRolePO sysRole, Integer pageNum, Integer pageSize){
        long total = sysRoleService.countTotal(sysRole);
        List<SysRolePO> dataList = sysRoleService.getRoleList(sysRole, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList),"请求角色列表数据成功");
    }

    /**
     * 获取角色信息
     * @param id
     * @return 角色信息
     */
    @RequestMapping(value = "/getRoleById/{id}", method = RequestMethod.GET)
    public Result getRoleById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取角色信息失败");
        }
        SysRolePO sysRole = sysRoleService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysRole, "获取角色信息成功");
    }

    /**
     * 执行添加操作
     * @param sysRole
     * @return 执行结果
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody SysRolePO sysRole) {
        sysRoleService.create(sysRole);
        return ResultFactory.buildSuccessResult(null, "添加角色成功");
    }

    /**
     * 执行更新操作
     * @param sysRole
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody SysRolePO sysRole) {
        sysRoleService.update(sysRole);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
    @RequestMapping(value = "/logicDeleteById/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysRoleService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }
}
