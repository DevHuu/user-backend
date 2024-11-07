package com.hui.userbackend.converter;

import com.hui.userbackend.model.domain.Unit;
import com.hui.userbackend.model.dto.UnitRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 创建单元请求转换
 * @author liujh
 * @date 2024/11/5
 */
@Component
public class UnitRequestConverter {


    /**
     * 转换请求参数
     * @param unit
     * @return
     */
    public UnitRequestDTO converter(Unit unit) {
        UnitRequestDTO requestDTO = new UnitRequestDTO();
        BeanUtils.copyProperties(unit, requestDTO);
        String keywordTargetAction = unit.getKeywordTargetAction();
        if (StringUtils.isNotBlank(keywordTargetAction)) {
            List<Integer> list = getIntegerList(keywordTargetAction);
            requestDTO.setKeywordTargetAction(list);
        }
        String unitLandingPageDesc = unit.getUnitLandingPageDesc();
        if (StringUtils.isNotBlank(unitLandingPageDesc)) {
            List<String> stringList = getStringList(unitLandingPageDesc);
            requestDTO.setUnitLandingPageDesc(stringList);
        }
        // note_ids
        String noteIds = unit.getNoteIds();
        if (StringUtils.isNotBlank(noteIds)) {
            List<String> stringList = getStringList(noteIds);
            requestDTO.setNoteIds(stringList);
        }
        // 定向配置
        UnitRequestDTO.TargetConfigDTO targetConfigDTO = new UnitRequestDTO.TargetConfigDTO();
        BeanUtils.copyProperties(unit, targetConfigDTO);
        String interestKeywords = unit.getInterestKeywords();
        if (StringUtils.isNotBlank(interestKeywords)) {
            List<String> stringList = getStringList(interestKeywords);
            targetConfigDTO.setInterestKeywords(stringList);
        }
        String keywords = unit.getKeywords();
        if (StringUtils.isNotBlank(keywords)) {
            List<String> stringList = getStringList(keywords);
            targetConfigDTO.setKeywords(stringList);
        }
        requestDTO.setTargetConfig(targetConfigDTO);
        // spu&笔记标的信息
        String spuNoteInfo = unit.getSpuNoteInfo();
        if (StringUtils.isNotBlank(spuNoteInfo)) {
            List<UnitRequestDTO.SpuNoteInfoDTO> spuNoteInfoDTOS = getSpuNoteInfoDTOS(spuNoteInfo);
            requestDTO.setSpuNoteInfo(spuNoteInfoDTOS);
        }

        return requestDTO;
    }

    private List<UnitRequestDTO.SpuNoteInfoDTO> getSpuNoteInfoDTOS(String spuNoteInfo) {
        List<UnitRequestDTO.SpuNoteInfoDTO> spuNoteInfoDTOS = new ArrayList<>();
        String[] arr = spuNoteInfo.split(";");
        for (String row : arr) {
            if (StringUtils.isBlank(row)) {
                continue;
            }
            String[] split = row.split(":");
            if (split.length != 2) {
                continue;
            }
            UnitRequestDTO.SpuNoteInfoDTO spuNoteInfoDTO = new UnitRequestDTO.SpuNoteInfoDTO();
            spuNoteInfoDTO.setSpuId(split[0]);
            String[] split1 = split[1].split(",");
            spuNoteInfoDTO.setNoteIds(Arrays.asList(split1));
            spuNoteInfoDTOS.add(spuNoteInfoDTO);
        }
        return spuNoteInfoDTOS;
    }

    private List<Integer> getIntegerList(String param) {
        String[] split = param.split(",");
        List<Integer> list = new ArrayList<>();
        for (String str : split) {
            Integer value = Integer.valueOf(str.trim());
            list.add(value);
        }
        return list;
    }

    private List<String> getStringList(String param) {
        String[] split = param.split(",");
        return Arrays.asList(split);
    }
}
