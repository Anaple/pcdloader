package com.ktserver.ktserver.service

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.ktserver.ktserver.json.api.JsonCurrentUser
import com.ktserver.ktserver.json.api.JsonCurrentUserBack
import com.ktserver.ktserver.json.api.JsonLoginAccountApi
import com.ktserver.ktserver.sql.entity.UserTb
import com.ktserver.ktserver.sql.mapper.UserMapper
import com.ktserver.ktserver.utils.ErrorUtils
import com.ktserver.ktserver.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserTbService {
    @Autowired
    val userMapper:UserMapper? = null
    fun checkUser(token: String): Any? {
        val userId: Int? = JwtUtils.tokenGetUserId(token)
        val user = userMapper?.selectById(userId)
        return if (user != null){
            JsonCurrentUserBack(true, user!!.let { JsonCurrentUser(it?.username,"null",user!!.userId,it?.email,"user") })

        }else{
            ErrorUtils.errorCode(403, "认证失败")
        }
    }

    fun checkUserLogin(username:String,password:String,tokenTime: Int):Any {
        val queryWrapper = KtQueryWrapper(UserTb())
            .eq(UserTb::username,username)
            .eq(UserTb::password,password)
        val isUser:Int = userMapper!!.selectCount(queryWrapper).toInt()
        return if (isUser==1){
            val thisUser:UserTb = userMapper!!.selectOne(queryWrapper)
            val createToken = UserTb(userId = thisUser.userId,token = JwtUtils.getToken(thisUser,tokenTime))
            val updateToken = userMapper!!.updateById(createToken)
            if(updateToken>0) {

                JsonLoginAccountApi(thisUser.username, "ok", "user", "account", thisUser.token, tokenTime)
            } else{
                JsonLoginAccountApi("error", "guest", "account")
            }
        }else{
            JsonLoginAccountApi("error", "guest", "account")
        }

    }


}