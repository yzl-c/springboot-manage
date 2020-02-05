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
import owner.yuzl.manage.entity.po.ProcessHoliday;
import owner.yuzl.manage.service.ProcessHolidayService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/2/3 13:31
 * @Description：
 */
@RestController
@RequestMapping(value = "/holidayProcess")
public class ProcessHolidayController {
    private Logger logger = LoggerFactory.getLogger(ProcessHolidayController.class);

    @Autowired
    private ProcessHolidayService processHolidayService;

    /**
     * 获取分页查询结果
     * @param processHoliday
     * @param pageNum
     * @param pageSize
     * @return 查询结果
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result getHolidayProcesses(ProcessHoliday processHoliday, Integer pageNum, Integer pageSize) {
        long total = processHolidayService.countTotal(processHoliday);
        List<ProcessHoliday> dataList = processHolidayService.getHolidayProcesses(processHoliday, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "请求列表数据成功");
    }

    /**
     * 获取信息
     * @param id
     * @return 信息
     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Result getHolidayById(@PathVariable(value = "id") Long id) {
//        if (StringUtils.isEmpty(id)) {
//            return ResultFactory.buildFailResult("获取信息失败");
//        }
//        ProcessHoliday processHoliday = processHolidayService.getOneById(id);
//        return ResultFactory.buildSuccessResult(processHoliday, "获取信息成功");
//    }

    /**
     * 执行添加操作
     * @param processHoliday
     * @return 执行结果
     */
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public Result create(@RequestBody ProcessHoliday processHoliday) {
//        processHolidayService.create(processHoliday);
//        return ResultFactory.buildSuccessResult(null, "添加成功");
//    }

    /**
     * 执行审核操作
     * @param processHoliday
     * @return 审核结果
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result approve(@RequestBody ProcessHoliday processHoliday) {
        processHolidayService.approve(processHoliday);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
//        processHolidayService.logicDeleteById(id);
//        return ResultFactory.buildSuccessResult(null, "删除成功");
//    }

}
