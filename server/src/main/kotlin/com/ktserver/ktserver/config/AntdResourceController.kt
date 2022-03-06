package com.ktserver.ktserver.config

import org.springframework.boot.system.ApplicationHome
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.io.File
import java.util.*


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
        var folder = "/"
        //获取jar包所在的目录
        val jar = ApplicationHome(javaClass)
        //判断 OS
        //判断 OS
        val os = System.getProperty("os.name")
        if (os.lowercase(Locale.getDefault()).startsWith("win")) {
            folder = "\\"
        }

        try {
            val jarSource = jar.source
            //在jar包所在目录下生成文件夹用来存储上传的图片
            val imgPhotoPath = jarSource.parentFile.toString() + folder + "point_cloud" + folder

            val photoFileMain = File(imgPhotoPath)

            if (!photoFileMain.exists() || !photoFileMain.isDirectory) {
                photoFileMain.mkdir()
            }
            //Web映射
            registry.addResourceHandler("/point_cloud/**").addResourceLocations("file:$imgPhotoPath")

        } catch (e: Exception) {
            System.err.println(e)
        }
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET","POST","HEAD")
            .allowCredentials(true)
            .maxAge(3600)
            .allowedHeaders("*");
    }
}