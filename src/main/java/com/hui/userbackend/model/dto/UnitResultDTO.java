package com.hui.userbackend.model.dto;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujh
 * @date 2024/11/3
 */
@NoArgsConstructor
@Data
public class UnitResultDTO {

    /**
     * code
     */
    @Alias("code")
    private Integer code;
    /**
     * msg
     */
    @Alias("msg")
    private String msg;
    /**
     * success
     */
    @Alias("success")
    private Boolean success;
    /**
     * data
     */
    @Alias("data")
    private DataDTO data;

    /**
     * DataDTO
     */
    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * unitId
         */
        @Alias("unit_id")
        private Long unitId;
    }
}
