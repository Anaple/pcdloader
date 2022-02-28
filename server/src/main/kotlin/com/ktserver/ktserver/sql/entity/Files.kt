package com.ktserver.ktserver.sql.entity

import com.baomidou.mybatisplus.annotation.TableField
import lombok.Data

@Data
class Files {
    @TableField(value = "file_id")
    var fileId:Int? = null
    @TableField(value = "userid_f")
    var userId:Int? = null
    @TableField(value = "file_url")
    var fileUrl:String? = null
    @TableField(value = "is_deleted")
    var isDeleted:Boolean? = null
    @TableField(value = "file_name")
    var fileName:String? = null
    @TableField(value = "device_id")
    var deviceId:String? = null
}