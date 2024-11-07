package com.hui.userbackend.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.userbackend.model.domain.Campaign;
import com.hui.userbackend.model.domain.request.SearchRequest;
import com.hui.userbackend.service.CampaignService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @author liujh
 * @date 2024/11/4
 */
@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Resource
    private CampaignService campaignService;

    @PostMapping("/search")
    public List<Campaign> search(@RequestBody SearchRequest param) {
        QueryWrapper<Campaign> queryWrapper = new QueryWrapper<>();
        String campaignName = param.getCampaignName();
        if (StringUtils.isNotBlank(campaignName)) {
            queryWrapper.like("campaign_name", campaignName);
        }
        return campaignService.list(queryWrapper);
    }

    @GetMapping("/searchPage")
    public Page<Campaign> searchPage(String campaignName) {
        QueryWrapper<Campaign> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(campaignName)) {
            queryWrapper.like("campaignName", campaignName);
        }
        return campaignService.page(new Page<>(1, 2), queryWrapper);
    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public boolean uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Campaign.class, new PageReadListener<Campaign>(dataList -> {
            campaignService.saveBatch(dataList);
        })).sheet().doRead();
        return true;
    }

    /**
     * 文件下载
     */
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String name = "创建计划模板";
        String fileName = URLEncoder.encode(name, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        Campaign campaignDemo = getCampaignDemo();
        EasyExcel.write(response.getOutputStream(), Campaign.class)
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(20))
                .sheet(name)
                .doWrite(Collections.singletonList(campaignDemo));
    }

    /**
     * 删除计划
     */
    @PostMapping("/delete")
    public boolean delete(@RequestBody List<String> ids) throws IOException {
        return campaignService.removeByIds(ids);
    }

    /**
     * 创建计划
     */
    @PostMapping("/create")
    public boolean create(@RequestBody List<String> ids) throws IOException {
        QueryWrapper<Campaign> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("campaign_id");
        queryWrapper.in("id", ids);
        List<Campaign> campaignList = campaignService.list(queryWrapper);
        for (Campaign campaign : campaignList) {
            campaignService.create(campaign.getId().toString());
        }
        return true;
    }

    private Campaign getCampaignDemo() {
        Campaign campaign = new Campaign();
        campaign.setAdvertiserId(0L);
        campaign.setMarketingTarget(0);
        campaign.setCampaignName("xxx计划");
        campaign.setPlacement(0);
        campaign.setPromotionTarget(0);
        campaign.setEnable(0);
        campaign.setTimeType(0);
        campaign.setStartTime(new Date());
        campaign.setExpireTime(new Date());
        campaign.setTimePeriodType(0);
        String timePeriod = "000000000001111111111111";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(timePeriod);
        }
        String join = CollectionUtil.join(list, ",");
        campaign.setTimePeriod(join);
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
        campaign.setSearchBidRatio(1.0);
        campaign.setDeeplinkId(0L);
        campaign.setUniversalLinkId(0L);
        campaign.setDetectUrlLink("http://xxx.com");
        return campaign;
    }
}
