package owner.yuzl.manage.common.result;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 21:50
 * @Description：返回数据
 */
public class ResultFactory {

    public static Result buildSuccessResult(Object data, String message) {
        return buildResult(data, message, StatusCode.OK.getCode());
    }

    public static Result buildFailResult(String message) {
        return buildResult(null, message, StatusCode.SYSTEM_ERR.getCode());
    }

    public static Result buildResult(Object data, String message, Integer resultCode) {
        return new Result(data, message, resultCode);
    }

}
