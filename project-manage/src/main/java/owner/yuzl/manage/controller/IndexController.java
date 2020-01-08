package owner.yuzl.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author：yzl_c
 * @Date：2020/1/4 13:28
 * @Description：主Controller
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String defaultIndex() {
        return "manage/sysUser/index";
    }
}
