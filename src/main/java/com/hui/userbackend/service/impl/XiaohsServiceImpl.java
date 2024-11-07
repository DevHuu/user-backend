package com.hui.userbackend.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.hui.userbackend.constant.ConfigConstant;
import com.hui.userbackend.model.dto.TokenRequestDTO;
import com.hui.userbackend.model.dto.TokenResultDTO;
import com.hui.userbackend.service.ConfigService;
import com.hui.userbackend.service.XiaohsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liujh
 * @date 2024/11/2
 */
@Slf4j
@Service
public class XiaohsServiceImpl implements XiaohsService, ConfigConstant {

    private final String ASSERTION_TEMPLATE = "[Assertion failed] - argument {} must not be null, empty, or blank";

    @Resource
    private ConfigService configService;

    @Override
    public String getToken() {
        // 从数据库查询token
        String accessTokenExpiresInStr = configService.findTokenValue(ACCESS_TOKEN_EXPIRES_IN);
        String accessToken = configService.findTokenValue(ACCESS_TOKEN);
        if (!StringUtils.isAnyBlank(accessTokenExpiresInStr, accessToken)) {
            // 校验是否过期
            if (checkExpiresIn(accessTokenExpiresInStr)) {
                return accessToken;
            } else if (checkExpiresIn(configService.findTokenValue(REFRESH_TOKEN_EXPIRES_IN))) {
                // 刷新toke
                return postRefreshToken();
            }
        }
        return postToken();
    }

    @Override
    public String createCampaign(String param) {
        String url = "https://adapi.xiaohongshu.com/api/open/jg/campaign/create";
        log.info("createCampaign-url:{}", url);
        log.info("createCampaign-param:{}", param);
        String result = executePost(url, param);
        log.info("createCampaign-result:{}", result);
        return result;
    }

    @Override
    public String createUnit(String param) {
        String url = "https://adapi.xiaohongshu.com/api/open/jg/unit/create";
        log.info("createUnit-url:{}", url);
        log.info("createUnit-param:{}", param);
        String result = executePost(url, param);
        log.info("createUnit-result:{}", result);
        return result;
    }

    /**
     * 执行post请求
     * @param url
     * @param param
     * @return
     */
    private String executePost(String url, String param) {
        String token = getToken();
        return HttpRequest.post(url)
                .header("access-token", token)
                .body(param)
                .execute()
                .body();
    }

    /**
     * 请求token
     * @return
     */
    private String postToken() {
        String appIdStr = configService.findAccountValue(APP_ID);
        String secret = configService.findAccountValue(SECRET);
        String authCode = configService.findAccountValue(AUTH_CODE);
        Assert.notBlank(appIdStr, ASSERTION_TEMPLATE, APP_ID);
        Assert.notBlank(secret, ASSERTION_TEMPLATE, SECRET);
        Assert.notBlank(authCode, ASSERTION_TEMPLATE, AUTH_CODE);
        long appId = Long.parseLong(appIdStr);

        String url = "https://adapi.xiaohongshu.com/api/open/oauth2/access_token";
        TokenRequestDTO requestDTO = new TokenRequestDTO();
        requestDTO.setAppId(appId);
        requestDTO.setSecret(secret);
        requestDTO.setAuthCode(authCode);
        String jsonStr = JSONUtil.toJsonStr(requestDTO);
        log.info("token-request:{}", jsonStr);
        String result = HttpUtil.post(url, jsonStr);
        log.info("token-result:{}", result);
        TokenResultDTO tokenResultDTO = JSONUtil.toBean(result, TokenResultDTO.class);
        if (tokenResultDTO.getSuccess()) {
            TokenResultDTO.DataDTO data = tokenResultDTO.getData();
            return saveTokenInfo(data);
        } else {
            throw new RuntimeException("请求token失败：" + result);
        }
    }

    /**
     * 请求刷新token
     * @return
     */
    private String postRefreshToken() {
        String appIdStr = configService.findAccountValue(APP_ID);
        String secret = configService.findAccountValue(SECRET);
        String refreshToken = configService.findTokenValue(REFRESH_TOKEN);
        Assert.notBlank(appIdStr, ASSERTION_TEMPLATE, APP_ID);
        Assert.notBlank(secret, ASSERTION_TEMPLATE, SECRET);
        Assert.notBlank(refreshToken, ASSERTION_TEMPLATE, REFRESH_TOKEN);
        long appId = Long.parseLong(appIdStr);

        String url = "https://adapi.xiaohongshu.com/api/open/oauth2/refresh_token";
        TokenRequestDTO requestDTO = new TokenRequestDTO();
        requestDTO.setAppId(appId);
        requestDTO.setSecret(secret);
        requestDTO.setRefreshToken(refreshToken);
        String jsonStr = JSONUtil.toJsonStr(requestDTO);
        log.info("refreshToken-request:{}", jsonStr);
        String result = HttpUtil.post(url, jsonStr);
        log.info("refreshToken-result:{}", result);
        TokenResultDTO tokenResultDTO = JSONUtil.toBean(result, TokenResultDTO.class);
        if (tokenResultDTO.getSuccess()) {
            TokenResultDTO.DataDTO data = tokenResultDTO.getData();
            return saveTokenInfo(data);
        } else {
            throw new RuntimeException("请求refreshToken失败：" + result);
        }
    }

    /**
     * 保存token信息
     * @param data
     * @return
     */
    private String saveTokenInfo(TokenResultDTO.DataDTO data) {
        String accessToken = data.getAccessToken();
        Long accessTokenExpiresIn = data.getAccessTokenExpiresIn();
        String refreshToken = data.getRefreshToken();
        Long refreshTokenExpiresIn = data.getRefreshTokenExpiresIn();
        configService.saveTokenInfo(ACCESS_TOKEN, accessToken);
        configService.saveTokenInfo(ACCESS_TOKEN_EXPIRES_IN, String.valueOf(accessTokenExpiresIn));
        configService.saveTokenInfo(REFRESH_TOKEN, refreshToken);
        configService.saveTokenInfo(REFRESH_TOKEN_EXPIRES_IN, String.valueOf(refreshTokenExpiresIn));
        // 记录当前时间
        long currentTimeMillis = System.currentTimeMillis();
        configService.saveTokenInfo(UPDATE_TIME, String.valueOf(currentTimeMillis));
        return accessToken;
    }

    /**
     * 校验是否过期，单位秒
     * 提前5分钟
     * @param expiresInStr
     * @return
     */
    private boolean checkExpiresIn(String expiresInStr) {
        long expiresIn = Long.parseLong(expiresInStr);
        String updateTime = configService.findTokenValue(UPDATE_TIME);
        long updateTimeLong = Long.parseLong(updateTime) / 1000 + expiresIn;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return (updateTimeLong - (5 * 60)) > currentTimeMillis;
    }
}
