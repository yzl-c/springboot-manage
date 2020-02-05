package owner.yuzl.manage.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping(value = "/menu")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

    /**
     * 获取所有菜单(树结构)
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result menuList(){
        List<SysMenuPO> menus = sysMenuService.getAllMenus();
        return ResultFactory.buildSuccessResult(menus,"请求菜单数据成功");
    }

    /**
     * 查询菜单列表
     * @param
     * @return
     */
//    @RequiresPermissions(value = "menu:list")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result getMenusList(SysMenuPO sysMenu) {
//        long total = sysMenuService.countTotal(sysMenu);
        List<SysMenuPO> dataList = sysMenuService.getMenusList(sysMenu);
        return ResultFactory.buildSuccessResult(dataList, "获取菜单列表数据成功");
    }

    /**
     * 获取权限信息
     * @param id
     * @return 权限信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getMenuById(@PathVariable(value = "id") Long id) {
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
//    @RequiresPermissions(value = "menu:list:create")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result create(@RequestBody SysMenuPO sysMenu) {
        sysMenuService.create(sysMenu);
        return ResultFactory.buildSuccessResult(null, "添加权限成功");
    }

    /**
     * 执行更新操作
     * @param sysMenu
     * @return 执行结果
     */
//    @RequiresPermissions(value = "menu:list:update")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result update(@RequestBody SysMenuPO sysMenu) {
        sysMenuService.update(sysMenu);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
//    @RequiresPermissions(value = "menu:list:delete")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysMenuService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }

    /**
     * code唯一性
     * @param
     * @return
     */
    @RequestMapping(value = "/check/{code}", method = RequestMethod.GET)
    public Result checkCodeUnique(@PathVariable("code") String code) {
        List<SysMenuPO> data = sysMenuService.checkCodeUnique(code);
        return ResultFactory.buildSuccessResult(data, "获取菜单数据成功");
    }
}
