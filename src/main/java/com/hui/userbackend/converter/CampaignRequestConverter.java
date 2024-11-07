package com.hui.userbackend.converter;

import cn.hutool.core.date.DateUtil;
import com.hui.userbackend.model.domain.Campaign;
import com.hui.userbackend.model.dto.CampaignRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 创建计划请求转换
 * @author liujh
 * @date 2024/11/5
 */
@Component
public class CampaignRequestConverter {


    /**
     * 转换请求参数
     * @param campaign
     * @return
     */
    public CampaignRequestDTO converter(Campaign campaign) {
        CampaignRequestDTO requestDTO = new CampaignRequestDTO();
        BeanUtils.copyProperties(campaign, requestDTO);
        // 日期
        Date startTime = campaign.getStartTime();
        Date expireTime = campaign.getExpireTime();
        if (startTime != null) {
            String date = DateUtil.formatDate(startTime);
            requestDTO.setStartTime(date);
        }
        if (expireTime != null) {
            String date = DateUtil.formatDate(expireTime);
            requestDTO.setExpireTime(date);
        }
        // timePeriod
        String timePeriod = campaign.getTimePeriod();
        if (StringUtils.isNotBlank(timePeriod)) {
            String[] arr = timePeriod.split(",");
            if (arr.length == 7) {
                CampaignRequestDTO.TimePeriodDTO periodDTO = new CampaignRequestDTO.TimePeriodDTO();
                periodDTO.setMon(arr[0]);
                periodDTO.setTues(arr[1]);
                periodDTO.setWed(arr[2]);
                periodDTO.setThur(arr[3]);
                periodDTO.setFri(arr[4]);
                periodDTO.setSat(arr[5]);
                periodDTO.setSun(arr[6]);
                requestDTO.setTimePeriod(periodDTO);
            }
        }
        return requestDTO;
    }
}
