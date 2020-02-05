package owner.yuzl.manage.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.SysDepartmentPO;
import owner.yuzl.manage.service.SysDepartmentService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：部门Controller
 */
@RestController
@RequestMapping(value = "/department")
public class SysDepartmentController {
    private Logger logger = LoggerFactory.getLogger(SysDepartmentController.class);

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 获取分页查询结果
     * @param queryDepartment
     * @param pageNum
     * @param pageSize
     * @return 查询结果
     */
//    @RequiresPermissions(value = "department:list")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result getDepartments(SysDepartmentPO queryDepartment, Integer pageNum, Integer pageSize) {
        long total = sysDepartmentService.countTotal(queryDepartment);
        List<SysDepartmentPO> dataList = sysDepartmentService.getDepartments(queryDepartment, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "请求部门列表数据成功");
    }

    /**
     * 获取部门信息
     * @param id
     * @return 部门信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getDepartmentById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取部门信息失败");
        }
        SysDepartmentPO sysDepartmentPO = sysDepartmentService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysDepartmentPO, "获取部门信息成功");
    }

    /**
     * 执行添加操作
     * @param sysDepartmentPO
     * @return 执行结果
     */
//    @RequiresPermissions(value = "department:list:create")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result create(@RequestBody SysDepartmentPO sysDepartmentPO) {
        sysDepartmentService.create(sysDepartmentPO);
        return ResultFactory.buildSuccessResult(null, "添加部门成功");
    }

    /**
     * 执行更新操作
     * @param sysDepartmentPO
     * @return 执行结果
     */
//    @RequiresPermissions(value = "department:list:update")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result update(@RequestBody SysDepartmentPO sysDepartmentPO) {
        sysDepartmentService.update(sysDepartmentPO);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
//    @RequiresPermissions(value = "department:list:delete")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysDepartmentService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }

}
