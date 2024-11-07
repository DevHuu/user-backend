package com.hui.userbackend.converter;


import cn.hutool.json.JSONUtil;
import com.hui.userbackend.model.domain.Campaign;
import com.hui.userbackend.model.dto.CampaignRequestDTO;
import com.hui.userbackend.service.CampaignService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author liujh
 * @date 2024/11/5
 */
@SpringBootTest
class CampaignRequestConverterTest {

    @Resource
    private CampaignService campaignService;

    @Resource
    private CampaignRequestConverter campaignRequestConverter;

    @Test
    void testConverter() {
        Campaign campaign = campaignService.getById(9);
        CampaignRequestDTO requestDTO = campaignRequestConverter.converter(campaign);
        String jsonStr = JSONUtil.toJsonStr(requestDTO);
        System.out.println(jsonStr);
    }

}