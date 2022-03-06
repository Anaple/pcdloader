package com.ktserver.ktserver.sql.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data

@Data
@TableName("file")
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

    constructor()

    constructor(userId: Int?, fileUrl: String?,  fileName: String?) {
        this.userId = userId
        this.fileUrl = fileUrl
        this.fileName = fileName
    }
}