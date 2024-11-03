package com.hui.userbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName unit
 */
@TableName(value ="unit")
@Data
public class Unit implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 单元ID
     */
    private Long unitId;

    /**
     * 广告主ID
     */
    private Long advertiserId;

    /**
     * 计划ID
     */
    private Long campaignId;

    /**
     * 单元名称
     */
    private String unitName;

    /**
     * 出价/目标成本，单位分，自动控制不需要传
     */
    private Integer eventBid;

    /**
     * 推广标的（笔记1）
     */
    private Integer promotionTarget;

    /**
     * 定向类型，1-通投,2-智能定向, 3-高级定向
     */
    private Integer targetType;

    /**
     * 关键词时间周期，单位天，枚举包括 3，7，15，30
     */
    private Integer keywordTargetPeriod;

    /**
     * 关键词行为类型，1: 搜索，2: 互动，3: 阅读
     */
    private String keywordTargetAction;

    /**
     * 推广业务信息示例
     */
    private String businessTreeName;

    /**
     * 代投账号b的userId
     */
    private String substitutedUserId;

    /**
     * 单元选词方式：
     */
    private Integer keywordGenType;

    /**
     * 落地页ID，聚光落地页下必填
     */
    private String pageId;

    /**
     * 落地页Url，自研落地页下必填
     */
    private String landingPageUrl;

    /**
     * 外链Url，标的是外链落地页时必填
     */
    private String unitExternalPageUrl;

    /**
     * 落地页表单描述
     */
    private String unitLandingPageDesc;

    /**
     * 定向包id
     */
    private Long targetTemplateId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（逻辑删除）
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}