package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.Unit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author jklanling
* @description 针对表【unit】的数据库操作Service
* @createDate 2024-11-03 16:52:54
*/
public interface UnitService extends IService<Unit> {

    /**
     * 创建单元
     * @param id
     * @return
     */
    boolean create(String id);
}
