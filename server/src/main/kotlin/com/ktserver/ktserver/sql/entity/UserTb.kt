package com.ktserver.ktserver.sql.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data

@Data
@TableName("user")
class UserTb {
    @TableId
    @TableField(value = "userid")
    var userId:Int? = null
    @TableField(value = "username")
    var username:String? = null
    @TableField(value = "password")
    var password:String? = null
    @TableField(value = "email")
    var email:String? = null
    @TableField(value = "token")
    var token:String? = null
    @TableField(value = "wechat")
    var wechat:String? = null
    @TableField(value = "phone")
    var phone:String? = null

    constructor(userId: Int?, token: String?) {
        this.userId = userId
        this.token = token
    }

    constructor()

}