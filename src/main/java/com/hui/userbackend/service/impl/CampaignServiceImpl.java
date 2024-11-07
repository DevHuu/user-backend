package com.hui.userbackend.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.userbackend.converter.CampaignRequestConverter;
import com.hui.userbackend.mapper.CampaignMapper;
import com.hui.userbackend.model.domain.Campaign;
import com.hui.userbackend.model.dto.CampaignRequestDTO;
import com.hui.userbackend.model.dto.CampaignResultDTO;
import com.hui.userbackend.service.CampaignService;
import com.hui.userbackend.service.XiaohsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

/**
* @author jklanling
* @description 针对表【campaign】的数据库操作Service实现
* @createDate 2024-11-03 16:50:04
*/
@Slf4j
@Service
public class CampaignServiceImpl extends ServiceImpl<CampaignMapper, Campaign>
    implements CampaignService{

    @Resource
    private XiaohsService xiaohsService;

    @Resource
    private CampaignRequestConverter campaignRequestConverter;

    /**
     * 创建计划
     */
    @Override
    public boolean create(String id) {
        Campaign campaign = getById(id);
        if (campaign == null) {
            throw new NoSuchElementException();
        }
        CampaignRequestDTO requestDTO = campaignRequestConverter.converter(campaign);
        String param = JSONUtil.toJsonStr(requestDTO);
        String result = xiaohsService.createCampaign(param);
        CampaignResultDTO resultDTO = JSONUtil.toBean(result, CampaignResultDTO.class);
        if (resultDTO.getSuccess()) {
            Long campaignId = resultDTO.getData().getCampaignId();
            campaign.setCampaignId(campaignId);
            return updateById(campaign);
        } else {
            log.error("创建计划失败。id：{}，结果：{}", id, result);
            return false;
        }
    }
}




