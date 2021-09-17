package com.he.scurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description Security配置
 * @createTime 2021年09月14日 09:37:00
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    MyUserDetialService myUserDetialService;

    @Resource
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //以下五步是表单登录进行身份认证最简单的登陆环境
        http.formLogin() //表单登陆 1
                .and() //2
                .authorizeRequests() //下面的都是授权的配置 3
                .anyRequest() //任何请求 4
                .authenticated(); //访问任何资源都需要身份认证 5
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //auth.userDetailsService(myUserDetialService);
       auth.authenticationProvider(authenticationProvider());

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // 默认的密码加密方式
        return new BCryptPasswordEncoder();
    }


    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //设置数据对比源
        daoAuthenticationProvider.setUserDetailsService(myUserDetialService);
        //设置前端传过来的密码加密方式，仅用作对比
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
