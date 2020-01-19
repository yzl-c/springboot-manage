package owner.yuzl.manage.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 20:11
 * @Description：
 */
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
                .excludePathPatterns("/login","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
