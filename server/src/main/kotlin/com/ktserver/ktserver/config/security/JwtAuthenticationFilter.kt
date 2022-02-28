package com.ktserver.ktserver.config.security

import com.ktserver.ktserver.utils.JwtUtils.getAuthentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter : OncePerRequestFilter() {
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val authentication = getAuthentication(httpServletRequest)

            // 对用 token 获取到的用户进行校验
            SecurityContextHolder.getContext().authentication = authentication
            filterChain.doFilter(httpServletRequest, httpServletResponse)

        } catch (e: Exception) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired，登陆已过期")
        }
    }
}