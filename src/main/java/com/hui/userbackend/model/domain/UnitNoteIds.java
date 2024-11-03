package com.hui.userbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName unit_note_ids
 */
@TableName(value ="unit_note_ids")
@Data
public class UnitNoteIds implements Serializable {
    /**
     * 单元id
     */
    private Long unitId;

    /**
     * 笔记ID
     */
    private String noteId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}