package com.ktserver.ktserver.api.login.userlogin

import com.ktserver.ktserver.json.api.OutLoginData
import com.ktserver.ktserver.json.api.OutLoginMsg
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AntdOutLoginApi {

        @PostMapping("api/login/outLogin")
        fun msg1():Any {
            val data = OutLoginMsg("loginout")
            return OutLoginData(data, true)
        }

}