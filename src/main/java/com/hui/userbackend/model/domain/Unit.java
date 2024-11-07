package com.hui.userbackend.model.domain;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName unit
 */
@TableName(value ="unit")
@Data
@ExcelIgnoreUnannotated
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
    @ExcelProperty("广告主ID")
    private Long advertiserId;

    /**
     * 计划ID
     */
    @ExcelProperty("计划ID")
    private Long campaignId;

    /**
     * 单元名称
     */
    @ExcelProperty("单元名称")
    private String unitName;

    /**
     * 出价/目标成本，单位分，自动控制不需要传
     */
    @ExcelProperty("出价/目标成本")
    private Integer eventBid;

    /**
     * 标的-笔记id
     */
    @ExcelProperty("标的-笔记id")
    private String noteIds;

    /**
     * 推广标的（笔记1）
     */
    @ExcelProperty("推广标的（笔记1）")
    private Integer promotionTarget;

    /**
     * 定向类型，1-通投,2-智能定向, 3-高级定向
     */
    @ExcelProperty("定向类型")
    private Integer targetType;

    /**
     * 关键词时间周期，单位天，枚举包括 3，7，15，30
     */
    @ExcelProperty("关键词时间周期")
    private Integer keywordTargetPeriod;

    /**
     * 关键词行为类型，1: 搜索，2: 互动，3: 阅读
     */
    @ExcelProperty("关键词行为类型")
    private String keywordTargetAction;

    /**
     * 推广业务信息示例
     */
    @ExcelProperty("推广业务信息示例")
    private String businessTreeName;

    /**
     * 代投账号b的userId
     */
    @ExcelProperty("代投账号b的userId")
    private String substitutedUserId;

    /**
     * 单元选词方式：
     */
    @ExcelProperty("单元选词方式")
    private Integer keywordGenType;

    /**
     * 落地页ID，聚光落地页下必填
     */
    @ExcelProperty("落地页ID")
    private String pageId;

    /**
     * 落地页Url，自研落地页下必填
     */
    @ExcelProperty("落地页Url")
    private String landingPageUrl;

    /**
     * 外链Url，标的是外链落地页时必填
     */
    @ExcelProperty("外链Url")
    private String unitExternalPageUrl;

    /**
     * 落地页表单描述
     */
    @ExcelProperty("落地页表单描述")
    private String unitLandingPageDesc;

    /**
     * 定向包id
     */
    @ExcelProperty("定向包id")
    private Long targetTemplateId;

    /**
     * 性别，不限: all, 男: 0, 女: 1
     */
    @ExcelProperty("性别")
    private String targetGender;

    /**
     * 年龄，不限：all, 细分年龄段：18-22, 23-27, 28-32, 33-100，细分年龄后多个年龄段用#号分隔，如18-22#23-27
     */
    @ExcelProperty("年龄")
    private String targetAge;

    /**
     * 地域定向-城市，不限传 all
     */
    @ExcelProperty("地域定向-城市")
    private String targetCity;

    /**
     * 设备，不限: all, 苹果: ios, 安卓: android
     */
    @ExcelProperty("设备")
    private String targetDevice;

    /**
     * 兴趣定向
     */
    @ExcelProperty("兴趣定向")
    private String industryInterestTarget;

    /**
     * dmp人群包定向
     */
    @ExcelProperty("dmp人群包定向")
    private String crowdTarget;

    /**
     * 关键词兴趣
     */
    @ExcelProperty("关键词兴趣")
    private String interestKeywords;

    /**
     * 关键词行为
     */
    @ExcelProperty("关键词行为")
    private String keywords;

    /**
     * 智能扩量，0: 否，1: 是
     */
    @ExcelProperty("智能扩量")
    private Integer intelligentExpansion;

    /**
     * 搜索地域意图定向功能  0-关闭，1-开启
     */
    @ExcelProperty("搜索地域意图定向功能")
    private String searchTargetCityIntent;

    /**
     * spu&笔记标的信息
     */
    @ExcelProperty("spu&笔记标的信息")
    private String spuNoteInfo;

    /**
     * spu&笔记标的信息
     */
    @ExcelProperty("关键词")
    private String keywordWithBid;

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
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}