package owner.yuzl.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.SysDictypePO;
import owner.yuzl.manage.service.SysDictypeService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 10:46
 * @Description：
 */
@RestController
@RequestMapping("/sysDictype")
public class SysDictypeController {

    @Autowired
    SysDictypeService sysDictypeService;

    /**
     * code唯一性
     * @param
     * @return
     */
    @RequestMapping(value = "/checkCodeUnique/{code}", method = RequestMethod.GET)
    public Result checkCodeUnique(@PathVariable("code") String code) {
        List<SysDictypePO> data = sysDictypeService.checkCodeUnique(code);
        return ResultFactory.buildSuccessResult(data, "获取字典类型数据成功");
    }

    /**
     * 查询字典类型列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getDictypesList", method = RequestMethod.GET)
    public Result getDictypesList(SysDictypePO sysDictype, Integer pageNum, Integer pageSize) {
        long total = sysDictypeService.countTotal(sysDictype);
        List<SysDictypePO> dataList = sysDictypeService.getDictypesList(sysDictype, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "获取权限列表数据成功");
    }

    /**
     * 获取权限信息
     * @param id
     * @return 权限信息
     */
    @RequestMapping(value = "/getDictypeById/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取字典类型信息失败");
        }
        SysDictypePO sysDictype = sysDictypeService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysDictype, "获取字典类型信息成功");
    }

    /**
     * 执行添加操作
     * @param sysDictype
     * @return 执行结果
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody SysDictypePO sysDictype) {
        sysDictypeService.create(sysDictype);
        return ResultFactory.buildSuccessResult(null, "添加字典类型成功");
    }

    /**
     * 执行更新操作
     * @param sysDictype
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody SysDictypePO sysDictype) {
        sysDictypeService.update(sysDictype);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
    @RequestMapping(value = "/logicDeleteById/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysDictypeService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }
}
