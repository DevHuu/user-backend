package com.hui.userbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName config
 */
@TableName(value ="config")
@Data
public class Config implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类
     */
    private String category;

    /**
     * 字段名称
     */
    private String field;

    /**
     * 值
     */
    private String value;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}