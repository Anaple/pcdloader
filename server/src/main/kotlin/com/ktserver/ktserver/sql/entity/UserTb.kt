package com.ktserver.ktserver.sql.entity

import com.baomidou.mybatisplus.annotation.TableField
import lombok.Data

@Data
class UserTb {
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
}