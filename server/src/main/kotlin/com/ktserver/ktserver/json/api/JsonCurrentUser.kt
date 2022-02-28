package com.ktserver.ktserver.json.api


import java.sql.Timestamp

/**
 *  返回的json封装
 */

// CurrentUser
data class JsonCurrentUser(
        var name: String?,
        var avatar: String,
        var userid: Int?,
        var email: String?,
        var access: String,
)

//错误返回
data class Error(
        val data: ErrorData,
        val errorCode:Int,
        val errorMessage:String,
        val success: Boolean,

)
data class ErrorData (
        val isLogin:Boolean,
        )
//Outlogin
data class OutLoginMsg(
        val msg:String,
)
data class OutLoginData(
        val data: OutLoginMsg,
        val success: Boolean
)
// Back CurrentUser
data class JsonCurrentUserBack(var success: Boolean, var data: JsonCurrentUser)

// Table Default
data class JsonTableDeafultBack(var data: Any?, var total: Int, var success: Boolean) {

}


