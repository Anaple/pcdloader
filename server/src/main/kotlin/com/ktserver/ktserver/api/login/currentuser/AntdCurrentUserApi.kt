package com.ktserver.ktserver.api.login.currentuser

import com.ktserver.ktserver.json.api.JsonCurrentUser
import com.ktserver.ktserver.json.api.JsonCurrentUserBack
import com.ktserver.ktserver.service.UserTbService
import com.ktserver.ktserver.utils.ErrorUtils
import com.ktserver.ktserver.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * @program: pure_web_server
 * @description: 验证用户Api
 * @author ASUS
 * @date 2021-11-29 19:27:03
 */
@RestController
class AntdCurrentUserApi {
    @Autowired
    val userTbService:UserTbService ? =null;
    @GetMapping("api/currentUser")
    fun currentUser(
            @RequestParam(value = "token", required = false) token: String?,
            @RequestParam(value = "username", required = false) username: String?,
    ): Any? {
        return if (JwtUtils.verify(token)) {
            if (token != null) {
                userTbService?.checkUser(token)
            }else{
                ErrorUtils.errorCode(401, "请登录")
            }

        } else {
            ErrorUtils.errorCode(401, "请登录")
        }


    }
}