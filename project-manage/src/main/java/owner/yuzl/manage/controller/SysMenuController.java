package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.entity.po.SysMenuPO;
import owner.yuzl.manage.service.SysMenuService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/20 18:21
 * @Description：系统菜单Controller
 */
@RestController
@RequestMapping(value = "/sysMenu")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

    /**
     * 获取所有菜单(树结构)
     * @return
     */
    @RequestMapping(value = "/getAllMenus", method = RequestMethod.GET)
    public Result menuList(){
        List<SysMenuPO> menus = sysMenuService.getAllMenus();
        return ResultFactory.buildSuccessResult(menus,"请求菜单数据成功");
    }

    /**
     * 查询菜单列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getMenusList", method = RequestMethod.GET)
    public Result getMenusList(SysMenuPO sysMenu) {
//        long total = sysMenuService.countTotal(sysMenu);
        List<SysMenuPO> dataList = sysMenuService.getMenusList(sysMenu);
        return ResultFactory.buildSuccessResult(dataList, "获取权限列表数据成功");
    }

    /**
     * 获取权限信息
     * @param id
     * @return 权限信息
     */
    @RequestMapping(value = "/getMenuById/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取权限信息失败");
        }
        SysMenuPO sysMenu = sysMenuService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysMenu, "获取权限信息成功");
    }

    /**
     * 执行添加操作
     * @param sysMenu
     * @return 执行结果
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody SysMenuPO sysMenu) {
        sysMenuService.create(sysMenu);
        return ResultFactory.buildSuccessResult(null, "添加权限成功");
    }

    /**
     * 执行更新操作
     * @param sysMenu
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody SysMenuPO sysMenu) {
        sysMenuService.update(sysMenu);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
    @RequestMapping(value = "/logicDeleteById/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysMenuService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }
}
