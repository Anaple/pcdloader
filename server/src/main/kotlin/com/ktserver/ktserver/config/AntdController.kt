package com.ktserver.ktserver.config

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


/**
 * @program: pure_web_server
 * @description: Antd拦截器
 * @author ASUS
 * @date 2021-12-02 21:43:18
 */
@Controller
class AntdController : ErrorController {
    fun getErrorPath(): String? {
        return "/error"
    }

    @RequestMapping("/error")
    fun getIndex(): String? {
        return "index"
    }

    @RequestMapping(value = ["/", "/user", "/user/", "/list"])
    fun fowardIndex(): String? {
        return "index"
    }


}