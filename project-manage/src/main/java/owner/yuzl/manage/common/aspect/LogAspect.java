package owner.yuzl.manage.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 15:20
 * @Description：
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * owner.yuzl.manage.controller.*.*(..))")
    public void LogAspect() {
    }

    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        String controllerName = joinPoint.getTarget().getClass().getName();
        log.info("进入--" + controllerName + "--");
    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint) {

    }

    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        String controllerName = joinPoint.getTarget().getClass().getName();
        log.info("退出--" + controllerName + "--");
    }

    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint) {
        String controllerName = joinPoint.getTarget().getClass().getName();
        log.info("异常--" + controllerName + "--");
    }

}