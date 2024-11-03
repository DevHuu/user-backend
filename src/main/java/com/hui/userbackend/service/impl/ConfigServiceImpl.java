package com.hui.userbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.userbackend.model.domain.Config;
import com.hui.userbackend.service.ConfigService;
import com.hui.userbackend.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

import static com.hui.userbackend.constant.ConfigConstant.ACCOUNT_CATEGORY;
import static com.hui.userbackend.constant.ConfigConstant.TOKEN_CATEGORY;

/**
* @author jklanling
* @description 针对表【config】的数据库操作Service实现
* @createDate 2024-11-03 16:52:54
*/
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config>
    implements ConfigService{

    /**
     * 查询account值
     */
    @Override
    public String findAccountValue(String field) {
        Config one = findAccountInfo(field);
        if (one != null) {
            return one.getValue();
        }
        return null;
    }

    /**
     * 查询account信息
     */
    @Override
    public Config findAccountInfo(String field) {
        QueryWrapper<Config> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category", ACCOUNT_CATEGORY);
        queryWrapper.eq("field", field);
        return getOne(queryWrapper);
    }

    /**
     * 保存account信息
     */
    @Override
    public boolean saveAccountInfo(String field, String value) {
        Config config = findAccountInfo(field);
        if (config == null) {
            config = new Config();
            config.setCategory(ACCOUNT_CATEGORY);
            config.setField(field);
        }
        config.setValue(value);
        return saveOrUpdate(config);
    }

    /**
     * 查询token值
     */
    @Override
    public String findTokenValue(String field) {
        Config one = findTokenInfo(field);
        if (one != null) {
            return one.getValue();
        }
        return null;
    }

    /**
     * 查询token信息
     */
    @Override
    public Config findTokenInfo(String field) {
        QueryWrapper<Config> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category", TOKEN_CATEGORY);
        queryWrapper.eq("field", field);
        return getOne(queryWrapper);
    }

    /**
     * 保存token信息
     */
    @Override
    public boolean saveTokenInfo(String field, String value) {
        Config config = findTokenInfo(field);
        if (config == null) {
            config = new Config();
            config.setCategory(TOKEN_CATEGORY);
            config.setField(field);
        }
        config.setValue(value);
        return saveOrUpdate(config);
    }

}




