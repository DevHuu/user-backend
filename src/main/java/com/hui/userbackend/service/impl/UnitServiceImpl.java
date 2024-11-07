package com.hui.userbackend.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.userbackend.converter.UnitRequestConverter;
import com.hui.userbackend.mapper.UnitMapper;
import com.hui.userbackend.model.domain.Unit;
import com.hui.userbackend.model.dto.UnitRequestDTO;
import com.hui.userbackend.model.dto.UnitResultDTO;
import com.hui.userbackend.service.UnitService;
import com.hui.userbackend.service.XiaohsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

/**
* @author jklanling
* @description 针对表【unit】的数据库操作Service实现
* @createDate 2024-11-03 16:52:54
*/
@Slf4j
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
    implements UnitService{

    @Resource
    private XiaohsService xiaohsService;

    @Resource
    private UnitRequestConverter unitRequestConverter;

    /**
     * 创建计划
     */
    @Override
    public boolean create(String id) {
        Unit unit = getById(id);
        if (unit == null) {
            throw new NoSuchElementException();
        }
        UnitRequestDTO requestDTO = unitRequestConverter.converter(unit);
        String param = JSONUtil.toJsonStr(requestDTO);
        String result = xiaohsService.createUnit(param);
        UnitResultDTO resultDTO = JSONUtil.toBean(result, UnitResultDTO.class);
        if (resultDTO.getSuccess()) {
            Long unitId = resultDTO.getData().getUnitId();
            unit.setUnitId(unitId);
            return updateById(unit);
        } else {
            log.error("创建单元失败。id：{}，结果：{}", id, result);
            return false;
        }
    }

}




