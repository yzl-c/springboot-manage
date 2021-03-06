package owner.yuzl.manage.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.SysPermissionPO;
import owner.yuzl.manage.service.SysPermissionService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/23 12:31
 * @Description：权限Controller
 */
@RestController
@RequestMapping(value = "/permission")
public class SysPermissionController {
    @Autowired
    SysPermissionService sysPermissionService;

    /**
     * code唯一性
     * @param
     * @return
     */
//    @RequestMapping(value = "/checkCodeUnique/{code}", method = RequestMethod.GET)
//    public Result checkCodeUnique(@PathVariable("code") String code) {
//        List<SysPermissionPO> data = sysPermissionService.checkCodeUnique(code);
//        return ResultFactory.buildSuccessResult(data, "获取权限数据成功");
//    }

    /**
     * 查询权限列表
     * @param
     * @return
     */
//    @RequiresPermissions(value = "permission:list")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result getPermissionsList(SysPermissionPO sysPermission, Integer pageNum, Integer pageSize) {
        long total = sysPermissionService.countTotal(sysPermission);
        List<SysPermissionPO> dataList = sysPermissionService.getPermissionsList(sysPermission, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "获取权限列表数据成功");
    }

    /**
     * 查询权限列表（树结构）
     * @param
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result getAllPermissionsTree() {
        List<SysPermissionPO> dataList = sysPermissionService.getPermissionsTree();
        return ResultFactory.buildSuccessResult(dataList, "获取权限列表数据成功");
    }

    /**
     * 等级查询权限列表
     * @param level
     * @return
     */
//    @RequestMapping(value = "/getPermissionsByLevel/{level}", method = RequestMethod.GET)
//    public Result getPermissionsByLevel(@PathVariable("level") Integer level) {
//        List<SysPermissionPO> dataList = sysPermissionService.getPermissionsByLevel(level);
//        return ResultFactory.buildSuccessResult(dataList, "获取权限列表数据成功");
//    }

    /**
     * 获取权限信息
     * @param id
     * @return 权限信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取权限信息失败");
        }
        SysPermissionPO sysPermission = sysPermissionService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysPermission, "获取权限信息成功");
    }

    /**
     * 执行添加操作
     * @param sysPermission
     * @return 执行结果
     */
//    @RequiresPermissions(value = "permission:list:create")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result create(@RequestBody SysPermissionPO sysPermission) {
        sysPermissionService.create(sysPermission);
        return ResultFactory.buildSuccessResult(null, "添加权限成功");
    }

    /**
     * 执行更新操作
     * @param sysPermission
     * @return 执行结果
     */
//    @RequiresPermissions(value = "permission:list:update")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result update(@RequestBody SysPermissionPO sysPermission) {
        sysPermissionService.update(sysPermission);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
//    @RequiresPermissions(value = "permission:list:delete")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysPermissionService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }
}
