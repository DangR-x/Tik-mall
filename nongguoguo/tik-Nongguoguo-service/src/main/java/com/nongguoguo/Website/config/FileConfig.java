package com.nongguoguo.Website.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 图片处理器
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //表示E:/xiong/imagex/下的文件解析成/xiong/**的路径可以访问,
        registry.addResourceHandler("/imagex/**").addResourceLocations("file:E:/xiong/imagex/");
    }
}
