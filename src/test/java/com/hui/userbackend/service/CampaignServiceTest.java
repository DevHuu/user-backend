package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.Campaign;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @author liujh
 * @date 2024/11/3
 */
@SpringBootTest
class CampaignServiceTest {

    @Resource
    private CampaignService campaignService;

    @Test
    void testAdd() {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(0L);
        campaign.setAdvertiserId(0L);
        campaign.setMarketingTarget(0);
        campaign.setCampaignName("123");
        campaign.setPlacement(0);
        campaign.setPromotionTarget(0);
        campaign.setEnable(0);
        campaign.setTimeType(0);
        campaign.setStartTime(new Date());
        campaign.setExpireTime(new Date());
        campaign.setTimePeriodType(0);
        campaign.setTimePeriod("");
        campaign.setBiddingStrategy(0);
        campaign.setLimitDayBudget(0);
        campaign.setCampaignDayBudget(0);
        campaign.setOptimizeTarget(0);
        campaign.setConstraintType(0);
        campaign.setSmartSwitch(0);
        campaign.setPacingMode(0);
        campaign.setFeedFlag(0);
        campaign.setBuildType(0);
        campaign.setEventAssetId(0L);
        campaign.setAssetEvent(0);
        campaign.setAssetEventId(0L);
        campaign.setPageCategory(0);
        campaign.setSearchFlag(0);
        campaign.setTargetExtensionSwitch(0);
        campaign.setSearchBidRatio(0);
        campaign.setDeeplinkId(0L);
        campaign.setUniversalLinkId(0L);
        campaign.setDetectUrlLink("22222");

        boolean result = campaignService.save(campaign);
        System.out.printf("userId:%s   ", campaign.getId());
        System.out.println(result);
        Assert.isTrue(result, "失败");
    }
}