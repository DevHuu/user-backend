package com.hui.userbackend.converter;


import cn.hutool.json.JSONUtil;
import com.hui.userbackend.model.domain.Unit;
import com.hui.userbackend.model.dto.UnitRequestDTO;
import com.hui.userbackend.service.UnitService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author liujh
 * @date 2024/11/5
 */
@SpringBootTest
class UnitRequestConverterTest {

    @Resource
    private UnitRequestConverter unitRequestConverter;

    @Resource
    private UnitService unitService;

    @Test
    void testConverter() {
        Unit unit = unitService.getById(1);
        UnitRequestDTO requestDTO = unitRequestConverter.converter(unit);
        String jsonStr = JSONUtil.toJsonStr(requestDTO);
        System.out.println(jsonStr);
    }

}