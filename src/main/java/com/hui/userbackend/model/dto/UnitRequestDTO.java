package com.hui.userbackend.model.dto;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liujh
 * @date 2024/11/3
 */
@NoArgsConstructor
@Data
public class UnitRequestDTO {

    /**
     * advertiserId
     */
    @Alias("advertiser_id")
    private Long advertiserId;
    /**
     * campaignId
     */
    @Alias("campaign_id")
    private Long campaignId;
    /**
     * unitName
     */
    @Alias("unit_name")
    private String unitName;
    /**
     * eventBid
     */
    @Alias("event_bid")
    private Integer eventBid;
    /**
     * noteIds
     */
    @Alias("note_ids")
    private List<String> noteIds;
    /**
     * promotionTarget
     */
    @Alias("promotion_target")
    private Integer promotionTarget;
    /**
     * targetType
     */
    @Alias("target_type")
    private Integer targetType;
    /**
     * targetConfig
     */
    @Alias("target_config")
    private TargetConfigDTO targetConfig;
    /**
     * keywordTargetPeriod
     */
    @Alias("keyword_target_period")
    private Integer keywordTargetPeriod;
    /**
     * keywordTargetAction
     */
    @Alias("keyword_target_action")
    private List<Integer> keywordTargetAction;
    /**
     * businessTreeName
     */
    @Alias("business_tree_name")
    private String businessTreeName;
    /**
     * spuNoteInfo
     */
    @Alias("spu_note_info")
    private List<SpuNoteInfoDTO> spuNoteInfo;
    /**
     * keywordWithBid
     */
    @Alias("keyword_with_bid")
    private List<KeywordWithBidDTO> keywordWithBid;
    /**
     * substitutedUserId
     */
    @Alias("substituted_user_id")
    private String substitutedUserId;
    /**
     * keywordGenType
     */
    @Alias("keyword_gen_type")
    private Integer keywordGenType;
    /**
     * pageId
     */
    @Alias("page_id")
    private String pageId;
    /**
     * landingPageUrl
     */
    @Alias("landing_page_url")
    private String landingPageUrl;
    /**
     * unitExternalPageUrl
     */
    @Alias("unit_external_page_url")
    private String unitExternalPageUrl;
    /**
     * unitLandingPageDesc
     */
    @Alias("unit_landing_page_desc")
    private List<String> unitLandingPageDesc;
    /**
     * targetTemplateId
     */
    @Alias("target_template_id")
    private Long targetTemplateId;

    /**
     * TargetConfigDTO
     */
    @NoArgsConstructor
    @Data
    public static class TargetConfigDTO {
        /**
         * targetGender
         */
        @Alias("target_gender")
        private String targetGender;
        /**
         * targetAge
         */
        @Alias("target_age")
        private String targetAge;
        /**
         * targetCity
         */
        @Alias("target_city")
        private String targetCity;
        /**
         * targetDevice
         */
        @Alias("target_device")
        private String targetDevice;
        /**
         * industryInterestTarget
         */
        @Alias("industry_interest_target")
        private IndustryInterestTargetDTO industryInterestTarget;
        /**
         * crowdTarget
         */
        @Alias("crowd_target")
        private CrowdTargetDTO crowdTarget;
        /**
         * keywords
         */
        @Alias("keywords")
        private List<String> keywords;
        /**
         * interestKeywords
         */
        @Alias("interest_keywords")
        private List<String> interestKeywords;
        /**
         * intelligentExpansion
         */
        @Alias("intelligent_expansion")
        private Integer intelligentExpansion;
        /**
         * searchTargetCityIntent
         */
        @Alias("search_target_city_intent")
        private String searchTargetCityIntent;

        /**
         * IndustryInterestTargetDTO
         */
        @NoArgsConstructor
        @Data
        public static class IndustryInterestTargetDTO {
            /**
             * contentInterests
             */
            @Alias("content_interests")
            private List<ContentInterestsDTO> contentInterests;
            /**
             * shoppingInterests
             */
            @Alias("shopping_interests")
            private List<ShoppingInterestsDTO> shoppingInterests;

            /**
             * ContentInterestsDTO
             */
            @NoArgsConstructor
            @Data
            public static class ContentInterestsDTO {
                /**
                 * code
                 */
                @Alias("code")
                private String code;
                /**
                 * name
                 */
                @Alias("name")
                private String name;
            }

            /**
             * ShoppingInterestsDTO
             */
            @NoArgsConstructor
            @Data
            public static class ShoppingInterestsDTO {
                /**
                 * code
                 */
                @Alias("code")
                private String code;
                /**
                 * name
                 */
                @Alias("name")
                private String name;
                /**
                 * children
                 */
                @Alias("children")
                private List<ChildrenDTO> children;

                /**
                 * ChildrenDTO
                 */
                @NoArgsConstructor
                @Data
                public static class ChildrenDTO {
                    /**
                     * code
                     */
                    @Alias("code")
                    private String code;
                    /**
                     * name
                     */
                    @Alias("name")
                    private String name;
                }
            }
        }

        /**
         * CrowdTargetDTO
         */
        @NoArgsConstructor
        @Data
        public static class CrowdTargetDTO {
            /**
             * crowdPkg
             */
            @Alias("crowd_pkg")
            private List<CrowdPkgDTO> crowdPkg;
            /**
             * value
             */
            @Alias("value")
            private String value;
            /**
             * name
             */
            @Alias("name")
            private String name;

            /**
             * CrowdPkgDTO
             */
            @NoArgsConstructor
            @Data
            public static class CrowdPkgDTO {
                /**
                 * value
                 */
                @Alias("value")
                private String value;
                /**
                 * name
                 */
                @Alias("name")
                private String name;
            }
        }
    }

    /**
     * SpuNoteInfoDTO
     */
    @NoArgsConstructor
    @Data
    public static class SpuNoteInfoDTO {
        /**
         * spuId
         */
        @Alias("spu_id")
        private String spuId;
        /**
         * noteIds
         */
        @Alias("note_ids")
        private List<String> noteIds;
    }

    /**
     * KeywordWithBidDTO
     */
    @NoArgsConstructor
    @Data
    public static class KeywordWithBidDTO {
        /**
         * keyword
         */
        @Alias("keyword")
        private String keyword;
        /**
         * bid
         */
        @Alias("bid")
        private Integer bid;
        /**
         * keywordSource
         */
        @Alias("keyword_source")
        private Integer keywordSource;
        /**
         * phraseMatchType
         */
        @Alias("phrase_match_type")
        private Integer phraseMatchType;
        /**
         * feedBid
         */
        @Alias("feed_bid")
        private Integer feedBid;
    }
}
