package com.ktserver.ktserver.json.api


import java.sql.Timestamp

/**
 *  返回的json封装
 */

// CurrentUser
data class JsonCurrentUser(
        var name: String,
        var avatar: String,
        var userid: String,
        var email: String,
        var access: String,
)

// Back CurrentUser
data class JsonCurrentUserBack(var success: Boolean, var data: JsonCurrentUser)

// Table Default
data class JsonTableDeafultBack(var data: Any?, var total: Int, var success: Boolean) {

}


