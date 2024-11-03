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
public class TokenResultDTO {

    /**
     * code
     */
    @Alias("code")
    private Integer code;
    /**
     * success
     */
    @Alias("success")
    private Boolean success;
    /**
     * msg
     */
    @Alias("msg")
    private String msg;
    /**
     * data
     */
    @Alias("data")
    private DataDTO data;

    /**
     * DataDTO
     */
    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * userId
         */
        @Alias("user_id")
        private String userId;
        /**
         * roleType
         */
        @Alias("role_type")
        private Integer roleType;
        /**
         * approvalAdvertisers
         */
        @Alias("approval_advertisers")
        private List<ApprovalAdvertisersDTO> approvalAdvertisers;
        /**
         * 用于获取新的 access_token 和 refresh_token，并且刷新过期时间
         */
        @Alias("refresh_token")
        private String refreshToken;
        /**
         * refresh_token 剩余有效时间，单位：秒
         */
        @Alias("refresh_token_expires_in")
        private Long refreshTokenExpiresIn;
        /**
         * approvalRoleType
         */
        @Alias("approval_role_type")
        private Integer approvalRoleType;
        /**
         * platformType
         */
        @Alias("platform_type")
        private Integer platformType;
        /**
         * 用于验证权限的 token
         */
        @Alias("access_token")
        private String accessToken;
        /**
         * access_token 剩余有效时间，单位：秒
         */
        @Alias("access_token_expires_in")
        private Long accessTokenExpiresIn;
        /**
         * appId
         */
        @Alias("app_id")
        private Long appId;
        /**
         * scope
         */
        @Alias("scope")
        private String scope;
        /**
         * corporationName
         */
        @Alias("corporation_name")
        private String corporationName;
        /**
         * createTime
         */
        @Alias("create_time")
        private Long createTime;
        /**
         * updateTime
         */
        @Alias("update_time")
        private Long updateTime;

        /**
         * ApprovalAdvertisersDTO
         */
        @NoArgsConstructor
        @Data
        public static class ApprovalAdvertisersDTO {
            /**
             * advertiserId
             */
            @Alias("advertiser_id")
            private Integer advertiserId;
            /**
             * advertiserName
             */
            @Alias("advertiser_name")
            private String advertiserName;
        }
    }
}
