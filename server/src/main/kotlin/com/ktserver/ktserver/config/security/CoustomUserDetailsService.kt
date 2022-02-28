package com.ktserver.ktserver.config.security

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.ktserver.ktserver.sql.entity.UserTb
import com.ktserver.ktserver.sql.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*


@Component
class CoustomUserDetailsService: UserDetailsService {
    @Autowired
    var userMapper: UserMapper? = null



    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails? {
        val queryWrapperUserWish = KtQueryWrapper(UserTb()).eq(UserTb::username,username)
        val user: UserTb = userMapper!!.selectOne( queryWrapperUserWish)
        val authorities: MutableCollection<GrantedAuthority> = ArrayList()

        //这里应该动态的从数据库里读取该用户的权限然后进行添加
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
        if (user!=null){
            return User(user.username, user.password,authorities)
        }else{
            return null
        }
    }
}