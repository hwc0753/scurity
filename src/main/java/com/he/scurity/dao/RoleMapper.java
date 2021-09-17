package com.he.scurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.scurity.domain.security.vo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年09月15日 16:40:00
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    Role getByUserId(@Param("id") Long id);
}
