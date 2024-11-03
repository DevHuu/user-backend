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
 * @TableName campaign
 */
@TableName(value ="campaign")
@Data
public class Campaign implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 计划ID
     */
    private Long campaignId;

    /**
     * 广告主ID
     */
    private Long advertiserId;

    /**
     * 营销目标（4：产品种草，9：客资收集，16：应用推广）
     */
    private Integer marketingTarget;

    /**
     * 计划名称（长度不超过50个字符）
     */
    private String campaignName;

    /**
     * 广告类型（1：信息流，2：搜索推广））
     */
    private Integer placement;

    /**
     * 推广标的类型，（1：笔记）
     */
    private Integer promotionTarget;

    /**
     * 计划创建后默认开启状态，1-开启，0-不开启，不传默认开启
     */
    private Integer enable;

    /**
     * 推广时时间类型,，0:长期投放，1:自定义设置开始结束时间
     */
    private Integer timeType;

    /**
     * 推广开始时间，格式 yyyy-MM-dd
     */
    private Date startTime;

    /**
     * 推广结束时间，格式 yyyy-MM-dd
     */
    private Date expireTime;

    /**
     * 推广时段类型, 0: 全时段，1:自定义时间段
     */
    private Integer timePeriodType;

    /**
     * 高级设置-自定义时间段（全时段可不传）
     */
    private String timePeriod;

    /**
     * 出价方式。
     */
    private Integer biddingStrategy;

    /**
     * 预算类型，0：不限预算，1：指定预算
     */
    private Integer limitDayBudget;

    /**
     * 计划日预算，单位分
     */
    private Integer campaignDayBudget;

    /**
     * 推广目标
     */
    private Integer optimizeTarget;

    /**
     * 成本控制类型
     */
    private Integer constraintType;

    /**
     * 节假日预算上浮, 0:关闭，1:开启
     */
    private Integer smartSwitch;

    /**
     * 投放速率, 1:匀速，2:加速
     */
    private Integer pacingMode;

    /**
     * 搜索追投
     */
    private Integer feedFlag;

    /**
     * 搭建类型
     */
    private Integer buildType;

    /**
     * 资产id。
     */
    private Long eventAssetId;

    /**
     * 资产事件类型
     */
    private Integer assetEvent;

    /**
     * 资产事件id
     */
    private Long assetEventId;

    /**
     * 落地页类型
     */
    private Integer pageCategory;

    /**
     * 搜索快投
     */
    private Integer searchFlag;

    /**
     * 搜索快投定向拓展
     */
    private Integer targetExtensionSwitch;

    /**
     * 搜索快投-出价系数
     */
    private Integer searchBidRatio;

    /**
     * deeplink链接id
     */
    private Long deeplinkId;

    /**
     * ulk的链接id
     */
    private Long universalLinkId;

    /**
     * 监测链接
     */
    private String detectUrlLink;

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