package com.hui.userbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.userbackend.model.domain.User;
import com.hui.userbackend.service.UserService;
import com.hui.userbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author liujh
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-05-13 22:30:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode) {
        return 0;
    }
}




