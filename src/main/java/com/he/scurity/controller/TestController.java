package com.he.scurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description 测试请求
 * @createTime 2021年09月14日 09:51:00
 */
@RestController
@RequestMapping("/v1")
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "ok";
    }


    @GetMapping("/test1")
    public String test1(){
        return "ok";
    }


}
