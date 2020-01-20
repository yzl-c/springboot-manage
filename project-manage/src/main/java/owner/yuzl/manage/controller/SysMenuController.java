package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
     * 获取左侧菜单栏
     * @return
     */
    @RequestMapping(value = "/getAllMenus", method = RequestMethod.GET)
    public Result menuList(){
        List<SysMenuPO> menus = sysMenuService.bulidAsideMenu();
        return ResultFactory.buildSuccessResult(menus,"请求菜单数据成功");
    }
}
