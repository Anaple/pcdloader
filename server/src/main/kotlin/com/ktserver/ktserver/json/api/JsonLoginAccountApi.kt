package com.ktserver.ktserver.json.api

/**
 * @program: pure_web_server
 * @description: LoginApi 返回
 * @author ASUS
 * @date 2021-11-29 19:43:15
 */
class JsonLoginAccountApi {
    private var name: String? = null
    private var status: String? = null
    private var currentAuthority: String? = null
    private var type: String? = null
    private var token: String? = null
    private var token_time = 0

    constructor()
    constructor(status: String?, currentAuthority: String?, type: String?) {
        this.status = status
        this.currentAuthority = currentAuthority
        this.type = type
    }

    constructor(
            name: String?,
            status: String?,
            currentAuthority: String?,
            type: String?,
            token: String?,
            token_time: Int,
    ) {
        this.name = name
        this.status = status
        this.currentAuthority = currentAuthority
        this.type = type
        this.token = token
        this.token_time = token_time
    }


    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getToken_time(): Int {
        return token_time
    }

    fun setToken_time(token_time: Int) {
        this.token_time = token_time
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getToken(): String? {
        return token
    }

    fun setToken(token: String?) {
        this.token = token
    }

    fun getCurrentAuthority(): String? {
        return currentAuthority
    }

    fun setCurrentAuthority(currentAuthority: String?) {
        this.currentAuthority = currentAuthority
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }
}