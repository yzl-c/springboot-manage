package owner.yuzl.manage.common.result;


/**
 * @Author：yzl_c
 * @Date：2020/1/18 21:50
 * @Description：返回状态码
 */
public enum  StatusCode {
    OK(200, "OK"),
    HTTP_ERROR_400(400, "4XX错误"),
    TOKEN_ERROR(401, "Token认证失败"),
    UNAUTHORIZED_ERROR(403, "您没有该权限"),
    SYSTEM_ERR(500, "服务器内错误");

    private int code;
    private String msg;

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

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
