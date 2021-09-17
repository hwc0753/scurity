package com.he.scurity.domain.security.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description t_role
 * @createTime 2021年09月15日 15:12:00
 */
@Data
@TableName("t_role")
public class Role {
    private long id;

    private String name;
}
