package owner.yuzl.manage.entity.base;

import com.alibaba.fastjson.JSON;

/**
 * @Author：yzl_c
 * @Date：2019/12/22 15:16
 * @Description：
 */
public class BaseResultInfo {
    private int code; //0成功,1失败

    private String msg; //描述信息

    private Object data; //返回数据

    public BaseResultInfo() {
    }

    public BaseResultInfo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResultInfo success(Object data) {
        return new BaseResultInfo(0, "操作成功！", data);
    }

    public static BaseResultInfo success(String msg, Object data) {
        return new BaseResultInfo(0, msg, data);
    }

    public static BaseResultInfo fail(Object data) {
        return new BaseResultInfo(1, "操作失败！", data);
    }

    public static BaseResultInfo fail(String msg, Object data) {
        return new BaseResultInfo(1, msg, data);
    }

    public static String successJson(String msg, Object data) {
        return JSON.toJSONString(BaseResultInfo.success(msg, data));
    }

    public static String successJson(Object data) {
        return successJson("", data);
    }

    public static String failJson(String msg, Object data) {
        return JSON.toJSONString(BaseResultInfo.fail(msg, data));
    }

    public static String failJson(Object data) {
        return failJson("", data);
    }

    public static String successMsg() {
        return "操作成功！";
    }

    public static String failMsg() {
        return "操作失败！";
    }

    @Override
    public String toString() {
        return "BaseResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
