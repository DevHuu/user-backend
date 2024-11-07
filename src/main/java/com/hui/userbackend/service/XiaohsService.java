package com.hui.userbackend.service;

/**
 * 小红书服务类
 * @author liujh
 * @date 2024/11/2
 */
public interface XiaohsService {

    /**
     * 获取token
     * @return
     */
    String getToken();

    /**
     * 创建计划
     * @param param 参数
     * @return
     */
    String createCampaign(String param);

    /**
     * 创建单元
     * @param param 参数
     * @return
     */
    String createUnit(String param);
}
