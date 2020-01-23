package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.SysMenuPO;
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
}
