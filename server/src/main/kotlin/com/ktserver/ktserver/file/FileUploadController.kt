package com.ktserver.ktserver.file

import com.ktserver.ktserver.service.FileManagerService
import com.ktserver.ktserver.service.StorageService
import com.ktserver.ktserver.sql.entity.Files
import com.ktserver.ktserver.utils.JwtUtils
import netscape.javascript.JSObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest
import kotlin.jvm.Throws

/**
 * @description 文件上传API
 * @author Linct
 * @program ktserver
 * @date 2022-2-28 17:21:09
 *
 */

@RestController
class FileUploadController {
    @Autowired
    val storageService:StorageService ?=null
    @Autowired
    val fileManagerService: FileManagerService?= null;
    @PostMapping("api/uploadFile")
    @Throws
    fun fileUpload(@RequestParam("file") file:MultipartFile,request:HttpServletRequest): Boolean? {
        var fileName = file.originalFilename
        val userName = JwtUtils.tokenGetName(request.getHeader(JwtUtils.XSRF))
        val userId = JwtUtils.tokenGetUserId(request.getHeader(JwtUtils.XSRF))
        if (fileName != null) {
            if (userName != null) {
                var num = 1
                while (true) {
                    if (fileName?.let {
                                fileManagerService!!.queryFileNameIsUsed(it
                                )
                            } == true) {
                        break;
                    }else{
                        fileName = "$fileName($num)";
                        num++
                    }
                }
               val storeAdd = fileName?.let { storageService!!.uploadFile(it,file,userName) }
               val fileSqlAdd = fileManagerService!!.addUserFiles(Files(userId=userId,fileUrl = "/point_cloud/$userName/$fileName",fileName = fileName))
                if (storeAdd == true &&fileSqlAdd){
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
        return false;

    }
}