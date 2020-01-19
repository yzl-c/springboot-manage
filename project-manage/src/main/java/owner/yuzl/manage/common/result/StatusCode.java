package owner.yuzl.manage.common.result;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 21:50
 * @Description：返回状态码
 */
public enum  StatusCode {
    SUCCESS(200),
    FAIL(400);
    public int code;

    StatusCode(int code) {
        this.code = code;
    }
}
