package owner.yuzl.manage.entity.base;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 17:55
 * @Description：返回结果封装分页实体类
 */
public class ResultInfoPage extends BaseResultInfo {
    private int count;

    public ResultInfoPage() {

    }

    public ResultInfoPage(int code, String msg, List data, int count) {
        super(code, msg, data);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static ResultInfoPage success(List data, int count) {
        return new ResultInfoPage(0, "操作成功！", data, count);
    }

    public static ResultInfoPage success(String msg, List data, int count) {
        return new ResultInfoPage(0, msg, data, count);
    }

    public static ResultInfoPage fail(List data, int count) {
        return new ResultInfoPage(1, "操作失败！", data, count);
    }

    public static ResultInfoPage fail(String msg, List data, int count) {
        return new ResultInfoPage(1, msg, data, count);
    }

    public static String successJson(String msg, List data, int count) {
        return JSON.toJSONString(ResultInfoPage.success(msg, data, count));
    }

    public static String successJson(List data, int count) {
        return successJson("", data, count);
    }

    public static String failJson(String msg, List data, int count) {
        return JSON.toJSONString(ResultInfoPage.fail(msg, data, count));
    }

    public static String failJson(List data) {
        return failJson("", data);
    }
}
