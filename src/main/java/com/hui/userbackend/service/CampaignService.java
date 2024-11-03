package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.Campaign;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author jklanling
* @description 针对表【campaign】的数据库操作Service
* @createDate 2024-11-03 16:50:04
*/
public interface CampaignService extends IService<Campaign> {

    /**
     * 创建计划
     * @param id
     * @return
     */
    boolean create(String id);
}
