package com.ktserver.ktserver.sql.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.ktserver.ktserver.sql.entity.UserTb
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper: BaseMapper<UserTb> {

}