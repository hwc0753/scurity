package com.he.scurity.config;

import com.he.scurity.domain.security.vo.Role;
import com.he.scurity.domain.security.vo.User;
import com.he.scurity.service.IRoleService;
import com.he.scurity.service.IUserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description 解析账户密码
 * @createTime 2021年09月14日 11:28:00
 */
@Component
public class MyUserDetialService implements UserDetailsService {
    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    IUserService userService;

    @Resource
    IRoleService roleService;



    /*
     * @author hewenchao
     * @description  返回的对象会和页面传输来的对象做对比
     * @Date: 2021/9/14 19:57
     * @param s:
     * @return: org.springframework.security.core.userdetails.UserDetails
     **/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.getUserByName(s);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        String pwd = user.getPassword();
        //此处根据用户名从数据库中查询查询用户
        String cryptPwd = passwordEncoder.encode(pwd);

        Role role =roleService.getByUserId(user.getId());


        //用户拼接权限
        return new org.springframework.security.core.userdetails.User (s, cryptPwd, AuthorityUtils.commaSeparatedStringToAuthorityList(role.getName())); //账号 密码 权限
    }
}
