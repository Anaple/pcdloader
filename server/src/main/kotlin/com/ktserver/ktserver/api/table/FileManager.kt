package com.ktserver.ktserver.api.table

import com.ktserver.ktserver.service.FileManagerService
import com.ktserver.ktserver.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class FileManager {
    @Autowired
    val fileManagerService:FileManagerService ?= null;
    @GetMapping("api/fileManager")
    fun getAllUserFiles(
        @RequestParam(value = "current", required = false) current: Int,
        @RequestParam(value = "pageSize", required = false) pageSize: Int,

        request: HttpServletRequest

    ): Any? {
        val token = request.getHeader(JwtUtils.XSRF)
        return JwtUtils.tokenGetUserId(token)?.let { fileManagerService!!.queryUserFiles(it,current,pageSize) }
    }

}