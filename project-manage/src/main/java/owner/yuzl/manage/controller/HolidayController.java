package owner.yuzl.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.po.Holiday;
import owner.yuzl.manage.service.HolidayService;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/2/3 13:31
 * @Description：
 */
@RestController
@RequestMapping(value = "/holiday")
public class HolidayController {
    private Logger logger = LoggerFactory.getLogger(HolidayController.class);

    @Autowired
    private HolidayService holidayService;

    /**
     * 获取分页查询结果
     * @param holiday
     * @param pageNum
     * @param pageSize
     * @return 查询结果
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result getHolidays(Holiday holiday, Integer pageNum, Integer pageSize) {
        long total = holidayService.countTotal(holiday);
        List<Holiday> dataList = holidayService.getHolidays(holiday, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "请求列表数据成功");
    }

    /**
     * 获取信息
     * @param id
     * @return 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getHolidayById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取信息失败");
        }
        Holiday holiday = holidayService.getOneById(id);
        return ResultFactory.buildSuccessResult(holiday, "获取信息成功");
    }

    /**
     * 执行添加操作
     * @param holiday
     * @return 执行结果
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result create(@RequestBody Holiday holiday) {
        holidayService.create(holiday);
        return ResultFactory.buildSuccessResult(null, "添加成功");
    }

    /**
     * 执行更新操作
     * @param holiday
     * @return 执行结果
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result update(@RequestBody Holiday holiday) {
        holidayService.update(holiday);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        holidayService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }

}
