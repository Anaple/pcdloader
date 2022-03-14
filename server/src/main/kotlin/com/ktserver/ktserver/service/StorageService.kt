package com.ktserver.ktserver.service

import org.springframework.boot.system.ApplicationHome
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

@Service
class StorageService {

    fun uploadFile(filename: String, file: MultipartFile,username:String): Boolean {
        return try {
            //获取jar包的位置
            val jar = ApplicationHome(javaClass)
            val jarSource = jar.source
            //在jar包所在目录下生成一个/point_cloud/{$username}
            val filePatch = jarSource.parentFile.toString() + "/point_cloud/$username/"
            val photoFileRepair = File(filePatch)
            if (!photoFileRepair.exists() || !photoFileRepair.isDirectory) {
                photoFileRepair.mkdir()
            }
            var ins  = file.inputStream
            val fos = FileOutputStream(filePatch+"$filename")
            var bytesRead = 0
            val buffer = ByteArray(81920)
            while (ins.read(buffer, 0, 81920).also { bytesRead = it } != -1) {
                fos.write(buffer, 0, bytesRead)
            }
            println(filePatch+filename)
            fos.close()
            ins.close()
            true
        } catch (e: Exception) {
            false
        }
    }
    fun deletedFile(filePath:String):Boolean{
        //获取jar包的位置
        val jar = ApplicationHome(javaClass)
        val jarSource = jar.source
        val path = jarSource.parentFile.toString()+filePath
        val file = File(path)
        if (file.isFile){
            file.delete()
            return true
        }else{
            return false
        }

    }
}