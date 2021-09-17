package com.he.scurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.scurity.domain.security.vo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description
 * @createTime 2021年09月15日 16:02:00
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
