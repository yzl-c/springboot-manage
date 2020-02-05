package owner.yuzl.manage.common.config;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.StatusCode;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author：yzl_c
 * @Date：2020/2/1 9:48
 * @Description：无权限异常处理
 */
public class UnauthorizedExceptionHandler {
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public Result globalException(HttpServletResponse response, UnauthorizedException ex){
        return ResultFactory.buildResult(null, "GlobalExceptionHandler:" + ex.getMessage(), StatusCode.UNAUTHORIZED_ERROR.getCode());
    }
}
