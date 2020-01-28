package owner.yuzl.manage.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.util.JWTUtil;
import owner.yuzl.manage.entity.po.SysUserPO;

import java.util.HashMap;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 21:50
 * @Description：登录Controller
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody SysUserPO user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(token);
            //获得用户对象
            SysUserPO resultUser = (SysUserPO) subject.getPrincipal();
            HashMap<Object, Object> data = new HashMap<>();
            data.put("loginUser", resultUser);
            //生成token返回给客户端
            data.put("token", JWTUtil.sign(resultUser));
            return ResultFactory.buildSuccessResult(data, "登录成功");
        } catch (AuthenticationException e) {
            //登录失败
            return ResultFactory.buildFailResult("登录失败");
        }
    }
/*    public static void main(String[] args) {
        //明码
        String password = "wxy";
        //加密算法
        String algorithmName = "MD5";
        //要加密的密码
        Object source = password;
        //盐值，一般都是用户名或者userid，要保证唯一
        Object salt = "wxy";
        //加密次数
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        //打印出经过盐值、加密次数、md5后的密码
        System.out.println(simpleHash.toString());
    }*/
}
