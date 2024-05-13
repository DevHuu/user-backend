package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liujh
* @description 针对表【user】的数据库操作Service
* @createDate 2024-05-13 22:30:10
*/
public interface UserService extends IService<User> {

    /**
     * 注册用户
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

}
