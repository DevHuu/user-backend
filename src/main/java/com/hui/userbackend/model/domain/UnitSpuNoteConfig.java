package com.hui.userbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName unit_spu_note_config
 */
@TableName(value ="unit_spu_note_config")
@Data
public class UnitSpuNoteConfig implements Serializable {
    /**
     * 单元id
     */
    private Long unitId;

    /**
     * spuId
     */
    private String spuId;

    /**
     * 笔记ID
     */
    private String noteId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}