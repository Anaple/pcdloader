package com.ktserver.ktserver.api.login.userlogin

import com.ktserver.ktserver.json.api.JsonLoginAccountApi
import com.ktserver.ktserver.json.api.JsonUserLoginApi
import com.ktserver.ktserver.service.UserTbService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


/**
 * @program: pure_web_server
 * @description: 用户登录Api
 * @author ASUS
 * @date 2021-11-29 19:32:10
 */
@RestController
class AntdUserLoginApi {
    @Autowired
    val userTbService: UserTbService? =null;
    @PostMapping("api/login/account")
    fun account(@RequestBody JSON_LoginUser: JsonUserLoginApi): Any? {
        return if (JSON_LoginUser.autoLogin == true) {
            userTbService?.checkUserLogin(JSON_LoginUser!!.username!!,JSON_LoginUser.password!!,99999*60)

        } else {
            userTbService?.checkUserLogin(JSON_LoginUser!!.username!!,JSON_LoginUser.password!!,9900*60)
        }
    }


}