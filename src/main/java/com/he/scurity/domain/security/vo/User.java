package com.he.scurity.domain.security.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description t_user 表
 * @createTime 2021年09月15日 15:06:00
 */
@Data
@TableName("t_user")
public class User {
    private Long id;

    private String name;

    private String password;
}
