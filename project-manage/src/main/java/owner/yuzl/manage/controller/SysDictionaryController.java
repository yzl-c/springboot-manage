package owner.yuzl.manage.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.SysDictionaryPO;
import owner.yuzl.manage.service.SysDictionaryService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/27 10:45
 * @Description：
 */
@RestController
@RequestMapping("/dictionary")
public class SysDictionaryController {

    @Autowired
    SysDictionaryService sysDictionaryService;

    /**
     * 查询字典列表
     * @param
     * @return
     */
//    @RequiresPermissions(value = "dictionary:list")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result getDictionarysList(SysDictionaryPO sysDictionary, Integer pageNum, Integer pageSize) {
        long total = sysDictionaryService.countTotal(sysDictionary);
        List<SysDictionaryPO> dataList = sysDictionaryService.getDictionarysList(sysDictionary, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "获取字典列表数据成功");
    }

    /**
     * 获取字典信息
     * @param id
     * @return 字典信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取字典类型信息失败");
        }
        SysDictionaryPO sysDictionary = sysDictionaryService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysDictionary, "获取字典类型信息成功");
    }

    /**
     * 执行添加操作
     * @param sysDictionary
     * @return 执行结果
     */
//    @RequiresPermissions(value = "dictionary:list:create")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result create(@RequestBody SysDictionaryPO sysDictionary) {
        sysDictionaryService.create(sysDictionary);
        return ResultFactory.buildSuccessResult(null, "添加字典类型成功");
    }

    /**
     * 执行更新操作
     * @param sysDictionary
     * @return 执行结果
     */
//    @RequiresPermissions(value = "dictionary:list:update")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result update(@RequestBody SysDictionaryPO sysDictionary) {
        sysDictionaryService.update(sysDictionary);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
//    @RequiresPermissions(value = "dictionary:list:delete")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysDictionaryService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }

    /**
     * code唯一性
     * @param
     * @return
     */
//    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
//    public Result checkCodeUnique(@PathVariable("code") String code) {
//        List<SysDictionaryPO> data = sysDictionaryService.checkCodeUnique(code);
//        return ResultFactory.buildSuccessResult(data, "获取字典数据成功");
//    }
}
