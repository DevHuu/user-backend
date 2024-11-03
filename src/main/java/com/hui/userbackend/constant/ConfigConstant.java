package com.hui.userbackend.constant;

/**
 * 配置常量
 * @author liujh
 * @date 2024/11/3
 */
public interface ConfigConstant {

    /**********Token begin**********/
    String TOKEN_CATEGORY = "token";

    String ACCESS_TOKEN = "accessToken";

    String ACCESS_TOKEN_EXPIRES_IN = "accessTokenExpiresIn";

    String REFRESH_TOKEN = "refreshToken";

    String REFRESH_TOKEN_EXPIRES_IN = "refreshTokenExpiresIn";
    /**********Token end**********/

    /**********Account begin**********/
    String ACCOUNT_CATEGORY = "account";
    String APP_ID = "appId";
    String SECRET = "secret";
    String AUTH_CODE = "authCode";
    /**********Account end**********/
}
