package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.Unit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author liujh
 * @date 2024/11/5
 */
@SpringBootTest
class UnitServiceTest {

    @Resource
    private UnitService unitService;

    @Test
    void testAdd() {
        Unit unit = new Unit();
        unit.setUnitId(0L);
        unit.setAdvertiserId(0L);
        unit.setCampaignId(0L);
        unit.setUnitName("bbb");
        unit.setEventBid(0);
        unit.setPromotionTarget(0);
        unit.setTargetType(0);
        unit.setKeywordTargetPeriod(0);
        unit.setKeywordTargetAction("");
        unit.setBusinessTreeName("");
        unit.setSubstitutedUserId("");
        unit.setKeywordGenType(0);
        unit.setPageId("");
        unit.setLandingPageUrl("");
        unit.setUnitExternalPageUrl("");
        unit.setUnitLandingPageDesc("");
        unit.setTargetTemplateId(0L);
        unitService.save(unit);
    }

}