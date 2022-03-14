package com.ktserver.ktserver.file

import com.ktserver.ktserver.service.FileManagerService
import com.ktserver.ktserver.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FileDeletedController {
    @Autowired
    val fileManagerService:FileManagerService?=null;

    @Autowired
    val storageService: StorageService?=null

    @PostMapping("/api/fileManager/delete")
    fun deletedFiles(@RequestBody data:Map<String,IntArray>): Boolean {
        var flag = false
        val intArr = data["key"]
        if (intArr != null) {
            for ( id in intArr ){
                val path = fileManagerService!!.queryFilePatch(id)
                if(fileManagerService!!.detetedFile(id)){
                    if (path != null) {
                         flag = storageService!!.deletedFile(path)
                    }
                }

            }
        }
        return  flag




    }
}