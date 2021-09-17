package com.he.scurity.service;

import com.he.scurity.domain.security.vo.Role;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年09月15日 16:57:00
 */
public interface IRoleService {
    Role getByUserId(Long id );
}
