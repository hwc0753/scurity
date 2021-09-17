package com.he.scurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.scurity.domain.security.vo.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description 查找权限
 * @createTime 2021年09月15日 21:35:00
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
