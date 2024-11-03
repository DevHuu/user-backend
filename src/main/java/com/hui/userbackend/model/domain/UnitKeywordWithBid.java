package com.hui.userbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName unit_keyword_with_bid
 */
@TableName(value ="unit_keyword_with_bid")
@Data
public class UnitKeywordWithBid implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 单元id
     */
    private Long unitId;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 关键词出价，手动出价时在0.3-10元之间，自动出价时为0。
     */
    private Integer bid;

    /**
     * 关键词来源，手动加词可以不传
     */
    private Integer keywordSource;

    /**
     * 匹配方式0:精确匹配, 1:短语匹配
     */
    private Integer phraseMatchType;

    /**
     * 搜索追投出价,开启搜索追投时必填，0.3-10元
     */
    private Integer feedBid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}