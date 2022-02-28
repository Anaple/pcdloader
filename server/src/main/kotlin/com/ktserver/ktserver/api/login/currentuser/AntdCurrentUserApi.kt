package com.ktserver.ktserver.api.login.currentuser

import com.ktserver.ktserver.json.api.JsonCurrentUser
import com.ktserver.ktserver.json.api.JsonCurrentUserBack
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
    @GetMapping("api/currentUser")
    fun currentUser(
            @RequestParam(value = "token", required = false) token: String?,
            @RequestParam(value = "username", required = false) username: String?,
    ): JsonCurrentUserBack {
        return JsonCurrentUserBack(true, JsonCurrentUser("Administrator", "https://avatars.githubusercontent.com/u/67675386?v=4", "?", "test", "admin"))


    }
}