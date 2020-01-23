package owner.yuzl.manage.controller;

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
@RequestMapping(value = "/sysPermission")
public class SysPermissionController {
    @Autowired
    SysPermissionService sysPermissionService;

    /**
     * 查询权限列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getPermissionsList", method = RequestMethod.GET)
    public Result getPermissionsList(SysPermissionPO sysPermission, Integer pageNum, Integer pageSize) {
        long total = sysPermissionService.countTotal(sysPermission);
        List<SysPermissionPO> dataList = sysPermissionService.getPermissionsList(sysPermission, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "获取权限列表数据成功");
    }

    /**
     * 获取权限信息
     * @param id
     * @return 权限信息
     */
    @RequestMapping(value = "/getPermissionById/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取用户信息失败");
        }
        SysPermissionPO sysPermission = sysPermissionService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysPermission, "获取用户信息成功");
    }

    /**
     * 执行添加操作
     * @param sysPermission
     * @return 执行结果
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody SysPermissionPO sysPermission) {
        sysPermissionService.create(sysPermission);
        return ResultFactory.buildSuccessResult(null, "添加用户成功");
    }

    /**
     * 执行更新操作
     * @param sysPermission
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody SysPermissionPO sysPermission) {
        sysPermissionService.update(sysPermission);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
    @RequestMapping(value = "/logicDeleteById/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysPermissionService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }
}
