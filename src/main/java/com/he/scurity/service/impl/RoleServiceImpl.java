package com.he.scurity.service.impl;

import com.he.scurity.dao.RoleMapper;
import com.he.scurity.domain.security.vo.Role;
import com.he.scurity.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年09月15日 16:57:00
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    RoleMapper roleMapper;
    @Override
    public Role getByUserId(Long id) {
        return roleMapper.getByUserId(id);
    }
}
