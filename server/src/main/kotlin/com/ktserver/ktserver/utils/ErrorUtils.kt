package com.ktserver.ktserver.utils

import com.ktserver.ktserver.json.api.ErrorData
import com.ktserver.ktserver.json.api.Error
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component


@Component
object ErrorUtils {
    fun errorCode(code: Int, message: String?): Any? {
        val data = ErrorData(false)
        val error = message?.let { Error(data, code, it, true) }
        return ResponseEntity<Any>(error, HttpStatus.valueOf(code))
    }
}