package com.anaple.pure_web_server.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/**
 * @program: pure_web_server
 * @description: Antd资源拦截器
 * @author ASUS
 * @date 2021-12-02 21:45:44
 */
@Configuration
@EnableWebMvc
class AntdResourceController : WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:dist/")
    }
}