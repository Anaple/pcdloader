package com.ktserver.ktserver.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.Claim
import com.auth0.jwt.interfaces.DecodedJWT
import com.ktserver.ktserver.sql.entity.UserTb
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.*
import javax.servlet.http.HttpServletRequest


object  JwtUtils {


    private const val SING = "¥#Fwjl980g" //设置密钥
    const val COOKIE_TOKEN = "COOKIE-TOKEN"
    const val XSRF = "X-XSRF-TOKEN"

    /**
     * create token
     * @param user
     * @return
     */
    fun getToken(user: UserTb,expireDate:Int): String? {

        //过期时间
        val date = Date(System.currentTimeMillis() + expireDate)
        val header: MutableMap<String, Any> = HashMap()
        header["typ"] = "JWT"
        header["alg"] = "HS256"

        return JWT.create()
            .withHeader(header)
            .withIssuer(user.username)
            .withSubject("currentuser")
            .withClaim("name", user.username)
            .withClaim("userid", user.userId)
            .withClaim("authorities","ROLE_USER")
            .withExpiresAt(date)
            .sign(Algorithm.HMAC256(SING))
    }

    /**
     *
     * check token
     * @param token
     * @return
     */
    fun verify(token: String?): Boolean {
        return try {
            JWT.require(Algorithm.HMAC256(SING)).build().verify(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     *
     * read token username
     * @param token
     * @return
     */
    fun tokenGetName(token: String?): String? {
        val data: DecodedJWT = getTokenInfo(token)
        val claims: Map<String, Claim> = data.claims
        val claim: Claim? = claims["name"]
        if (claim != null) {
            return claim.asString()
        }else{
            return null;
        }
    }
    fun tokenGetUserId(token: String?): Int? {
        val data: DecodedJWT = getTokenInfo(token)
        val claims: Map<String, Claim> = data.claims

        val claim: Claim? = claims["userid"]
        if (claim != null) {
            return claim.asInt()
        }else{
            return null;
        }
    }

    /**
     * read token access
     * @param token
     * @return
     */


    /**
     *
     * back token all data
     * @param token
     * @return
     */
    private fun getTokenInfo(token: String?): DecodedJWT {
    val data = JWT.require(Algorithm.HMAC256(SING)).build().verify(token)
        return data

    }

    /**
     * 对请求的验证
     */
    fun getAuthentication(request: HttpServletRequest?): Authentication? {
        val token: String? =request?.getHeader(XSRF)
        if (token != null && verify(token)) {
            val data: DecodedJWT = getTokenInfo(token)
            val claims: Map<String, Claim> = data.claims
            // 获取用户权限
            val authorities:  MutableCollection<GrantedAuthority> = ArrayList()
            authorities.add(SimpleGrantedAuthority(claims["authorities"]!!.asString()))
            val userName: String? = tokenGetName(token)
            if (userName != null) {
                val usernamePasswordAuthenticationToken =
                    UsernamePasswordAuthenticationToken(userName, null, authorities)
                usernamePasswordAuthenticationToken.details = claims
                return usernamePasswordAuthenticationToken
            }
            return null
        }
        return null
    }
}