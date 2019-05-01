package cn.zdxh.assistant.config;

import cn.zdxh.assistant.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;


/**
 * spring boot2.0以上实现WebMvcConfigurer
 * spring boot1.0版本继承WebMvcConfigurerAdapter
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //静态资源对外暴露的访问路径
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    //文件上传目录
    @Value("${file.uploadFolder}")
    private String uploadFolder ;

    //配置虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath+"**").addResourceLocations("file:"+uploadFolder);
    }
    //配置上传的临时文件夹
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/usr/java/upload/temp");
        return factory.createMultipartConfig();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/*");
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/admin/index","/admin/login","/css/**","/js/**");

    }


}
