package com.ktserver.ktserver.sql.entity

import com.baomidou.mybatisplus.annotation.TableField
import lombok.Data

@Data
class Device {
    @TableField(value = "device_id")
    var deviceId:String? = null
    @TableField(value = "device_name")
    var deviceName:String? = null
    @TableField(value = "device_create_time")
    var deviceCreateTime:String? = null
    @TableField(value = "device_info")
    var deviceInfo:String? = null
    @TableField(value = "userid_f")
    var userId:Int?=null

    constructor()
}