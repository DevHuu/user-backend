package com.hui.userbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName unit_target_config
 */
@TableName(value ="unit_target_config")
@Data
public class UnitTargetConfig implements Serializable {
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
     * 性别，不限: all, 男: 0, 女: 1
     */
    private String targetGender;

    /**
     * 年龄，不限：all, 细分年龄段：18-22, 23-27, 28-32, 33-100，细分年龄后多个年龄段用#号分隔，如18-22#23-27
     */
    private String targetAge;

    /**
     * 地域定向-城市，不限传 all
     */
    private String targetCity;

    /**
     * 设备，不限: all, 苹果: ios, 安卓: android
     */
    private String targetDevice;

    /**
     * 兴趣定向
     */
    private String industryInterestTarget;

    /**
     * dmp人群包定向
     */
    private String crowdTarget;

    /**
     * 关键词兴趣
     */
    private String interestKeywords;

    /**
     * 关键词行为
     */
    private String keywords;

    /**
     * 智能扩量，0: 否，1: 是
     */
    private Integer intelligentExpansion;

    /**
     * 搜索地域意图定向功能  0-关闭，1-开启
     */
    private String searchTargetCityIntent;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}