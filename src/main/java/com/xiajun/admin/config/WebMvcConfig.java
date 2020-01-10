package com.xiajun.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //如下配置则能可以访问src/main/resources/mysource下面的文件
        registry.addResourceHandler("/**").addResourceLocations("file:/Users/xiajun/03.Workspaces/ddj-video-files/");
        //如访问mysource文件夹下的a.jpg，则输入：localhost:8080/myprofix/a.jpg
    }
}
