package com.he.scurity.service;

import com.he.scurity.domain.security.vo.User;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description 系统用户基础信息
 * @createTime 2021年09月15日 15:50:00
 */
public interface IUserService  {

    User getUserByName(String name);
}
