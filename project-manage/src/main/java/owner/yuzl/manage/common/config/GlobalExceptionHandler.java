package owner.yuzl.manage.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author：yzl_c
 * @Date：2020/2/1 9:48
 * @Description：全局异常处理
 */
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result globalException(HttpServletResponse response, Exception ex){
        return ResultFactory.buildResult(null, "GlobalExceptionHandler:" + ex.getMessage(), response.getStatus());
    }
}
