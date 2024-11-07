package com.hui.userbackend.service;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.hui.userbackend.constant.ConfigConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liujh
 * @date 2024/11/3
 */
@SpringBootTest
class ConfigServiceTest implements ConfigConstant {

    @Resource
    private ConfigService configService;

    @Test
    void testAddToken() {
        String accessToken = "66121312asdfasdas321321";
        Long accessTokenExpiresIn = System.currentTimeMillis() / 1000;
        String refreshToken = "771213sad12asdf234asdas321321";
        Long refreshTokenExpiresIn = System.currentTimeMillis() / 1000;
        configService.saveTokenInfo(ACCESS_TOKEN, accessToken);
        configService.saveTokenInfo(ACCESS_TOKEN_EXPIRES_IN, String.valueOf(accessTokenExpiresIn));
        configService.saveTokenInfo(REFRESH_TOKEN, refreshToken);
        configService.saveTokenInfo(REFRESH_TOKEN_EXPIRES_IN, String.valueOf(refreshTokenExpiresIn));
    }

    @Test
    void testFindToken() {
        //System.out.println(configService.findTokenValue(ACCESS_TOKEN));
        //System.out.println(configService.findTokenValue(ACCESS_TOKEN_EXPIRES_IN));
        //System.out.println(configService.findTokenValue(REFRESH_TOKEN));
        //System.out.println(configService.findTokenValue(REFRESH_TOKEN_EXPIRES_IN));
        //System.out.println(configService.findTokenValue(REFRESH_TOKEN_EXPIRES_IN));
        DateTime offset = DateUtil.offset(new Date(), DateField.DAY_OF_MONTH, 1);
        System.out.println(offset);
        System.out.println(offset.getTime());
    }

    @Test
    void testAddAccount() {
        Long appId = System.currentTimeMillis() / 1000;
        String secret = "881213sad12asdf234asdas321321";
        String authCode = "991213sad12asdf234asdas321321";
        configService.saveAccountInfo(APP_ID, String.valueOf(appId));
        configService.saveAccountInfo(SECRET, secret);
        configService.saveAccountInfo(AUTH_CODE, authCode);
    }

    @Test
    void testFindAccount() {
        System.out.println(configService.findAccountValue(APP_ID));
        System.out.println(configService.findAccountValue(SECRET));
        System.out.println(configService.findAccountValue(AUTH_CODE));
    }

}