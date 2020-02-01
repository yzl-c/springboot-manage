package owner.yuzl.manage.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import owner.yuzl.manage.common.intercepter.TokenInterceptor;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 20:11
 * @Description：
 */
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;

    //构造方法
    public IntercepterConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
