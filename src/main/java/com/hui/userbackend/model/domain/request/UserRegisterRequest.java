package com.hui.userbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liujh
 * @date 2024/5/15
 */

@Data
public class UserRegisterRequest implements Serializable {
    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 校验密码
     */
    private String checkPassword;

    /**
     * 星球编号
     */
    private String planetCode;

}
