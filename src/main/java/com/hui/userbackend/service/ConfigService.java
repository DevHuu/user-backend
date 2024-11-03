package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.Config;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author jklanling
* @description 针对表【config】的数据库操作Service
* @createDate 2024-11-03 16:52:54
*/
public interface ConfigService extends IService<Config> {

    /**
     * 查询account值
     * @param field
     * @return
     */
    String findAccountValue(String field);

    /**
     * 查询account信息
     * @param field
     * @return
     */
    Config findAccountInfo(String field);

    /**
     * 保存account信息
     */
    boolean saveAccountInfo(String field, String value);

    /**
     * 查询token值
     */
    String findTokenValue(String field);

    /**
     * 查询token信息
     */
    Config findTokenInfo(String field);

    /**
     * 保存token信息
     */
    boolean saveTokenInfo(String field, String value);

}
