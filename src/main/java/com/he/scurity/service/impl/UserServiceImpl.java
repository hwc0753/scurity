package com.he.scurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.he.scurity.dao.UserMapper;
import com.he.scurity.domain.security.vo.User;
import com.he.scurity.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description
 * @createTime 2021年09月15日 15:52:00
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("name", name));
    }
}
