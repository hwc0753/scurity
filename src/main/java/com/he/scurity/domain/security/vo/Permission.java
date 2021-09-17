package com.he.scurity.domain.security.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description 权限实体
 * @createTime 2021年09月15日 21:33:00
 */
@Data
@TableName("t_permission")
public class Permission {
    private Long id;

    private String name;

    private String url;

    private String description;

    @TableField("p_id")
    private Long pId;
}
