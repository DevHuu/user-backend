package com.hui.userbackend.model.dto;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujh
 * @date 2024/11/3
 */
@NoArgsConstructor
@Data
public class CampaignRequestDTO {

    /**
     * advertiserId
     */
    @Alias("advertiser_id")
    private Integer advertiserId;
    /**
     * marketingTarget
     */
    @Alias("marketing_target")
    private Integer marketingTarget;
    /**
     * campaignName
     */
    @Alias("campaign_name")
    private String campaignName;
    /**
     * placement
     */
    @Alias("placement")
    private Integer placement;
    /**
     * promotionTarget
     */
    @Alias("promotion_target")
    private Integer promotionTarget;
    /**
     * timeType
     */
    @Alias("time_type")
    private Integer timeType;
    /**
     * startTime
     */
    @Alias("start_time")
    private String startTime;
    /**
     * expireTime
     */
    @Alias("expire_time")
    private String expireTime;
    /**
     * timePeriod
     */
    @Alias("time_period")
    private TimePeriodDTO timePeriod;
    /**
     * biddingStrategy
     */
    @Alias("bidding_strategy")
    private Integer biddingStrategy;
    /**
     * limitDayBudget
     */
    @Alias("limit_day_budget")
    private Integer limitDayBudget;
    /**
     * timePeriodType
     */
    @Alias("time_period_type")
    private Integer timePeriodType;
    /**
     * optimizeTarget
     */
    @Alias("optimize_target")
    private Integer optimizeTarget;
    /**
     * constraintType
     */
    @Alias("constraint_type")
    private Integer constraintType;
    /**
     * smartSwitch
     */
    @Alias("smart_switch")
    private Integer smartSwitch;
    /**
     * pacingMode
     */
    @Alias("pacing_mode")
    private Integer pacingMode;
    /**
     * enable
     */
    @Alias("enable")
    private Integer enable;
    /**
     * campaignDayBudget
     */
    @Alias("campaign_day_budget")
    private Integer campaignDayBudget;
    /**
     * feedFlag
     */
    @Alias("feed_flag")
    private Integer feedFlag;
    /**
     * buildType
     */
    @Alias("build_type")
    private Integer buildType;
    /**
     * eventAssetId
     */
    @Alias("event_asset_id")
    private Integer eventAssetId;
    /**
     * assetEvent
     */
    @Alias("asset_event")
    private Integer assetEvent;
    /**
     * assetEventId
     */
    @Alias("asset_event_id")
    private Integer assetEventId;
    /**
     * pageCategory
     */
    @Alias("page_category")
    private Integer pageCategory;
    /**
     * searchFlag
     */
    @Alias("search_flag")
    private Integer searchFlag;
    /**
     * targetExtensionSwitch
     */
    @Alias("target_extension_switch")
    private Integer targetExtensionSwitch;
    /**
     * searchBidRatio
     */
    @Alias("search_bid_ratio")
    private Integer searchBidRatio;
    /**
     * deeplinkId
     */
    @Alias("deeplink_id")
    private Integer deeplinkId;
    /**
     * universalLinkId
     */
    @Alias("universal_link_id")
    private Integer universalLinkId;
    /**
     * detectUrlLink
     */
    @Alias("detect_url_link")
    private String detectUrlLink;

    /**
     * TimePeriodDTO
     */
    @NoArgsConstructor
    @Data
    public static class TimePeriodDTO {
        /**
         * mon
         */
        @Alias("mon")
        private String mon;
        /**
         * tues
         */
        @Alias("tues")
        private String tues;
        /**
         * wed
         */
        @Alias("wed")
        private String wed;
        /**
         * thur
         */
        @Alias("thur")
        private String thur;
        /**
         * fri
         */
        @Alias("fri")
        private String fri;
        /**
         * sat
         */
        @Alias("sat")
        private String sat;
        /**
         * sun
         */
        @Alias("sun")
        private String sun;
    }
}
