package com.ktserver.ktserver.sql.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.ktserver.ktserver.sql.entity.Files
import org.apache.ibatis.annotations.Mapper

@Mapper
interface FileMapper:BaseMapper<Files> {
}