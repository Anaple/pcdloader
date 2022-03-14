package com.ktserver.ktserver.service

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.ktserver.ktserver.json.api.JsonTableDeafultBack
import com.ktserver.ktserver.sql.entity.Files
import com.ktserver.ktserver.sql.mapper.FileMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FileManagerService {
    @Autowired
    val fileMapper:FileMapper ? =null;

    fun queryUserFiles(userId:Int,current:Int,pageSize:Int):Any{
        val queryWrapper = KtQueryWrapper(Files())
            .eq(Files::userId,userId)
        val dataArr = fileMapper!!.selectPage(Page(current.toLong(),pageSize.toLong()),queryWrapper)
        return JsonTableDeafultBack(dataArr.records,dataArr.total.toInt(),true)
    }
    fun queryFileNameIsUsed(fileName:String):Boolean{
        val queryWapper = KtQueryWrapper(Files()).eq(Files::fileName,fileName)
        val isUsed = fileMapper?.selectList(queryWapper)!!.size == 0;
        return  isUsed

    }

    fun addUserFiles(files: Files):Boolean{
       return fileMapper!!.insert(files) >0
    }

}