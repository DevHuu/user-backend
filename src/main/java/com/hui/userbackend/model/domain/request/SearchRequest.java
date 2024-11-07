package com.hui.userbackend.model.domain.request;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujh
 * @date 2024/11/5
 */
@NoArgsConstructor
@Data
public class SearchRequest {
    /**
     * current
     */
    @Alias("current")
    private Integer current;
    /**
     * pageSize
     */
    @Alias("pageSize")
    private Integer pageSize;
    /**
     * campaignName
     */
    @Alias("campaignName")
    private String campaignName;
    /**
     * unitName
     */
    @Alias("unitName")
    private String unitName;
}
