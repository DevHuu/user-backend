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
public class TokenRequestDTO {

    /**
     * appId
     */
    @Alias("app_id")
    private Long appId;
    /**
     * secret
     */
    @Alias("secret")
    private String secret;
    /**
     * authCode
     */
    @Alias("auth_code")
    private String authCode;
    /**
     * refreshToken
     */
    @Alias("refresh_token")
    private String refreshToken;
}
