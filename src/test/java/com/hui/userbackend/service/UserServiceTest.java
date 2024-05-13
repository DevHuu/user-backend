package com.hui.userbackend.service;

import com.hui.userbackend.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;


/**
 * @author liujh
 * @date 2024/5/13
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("yupi");
        user.setUserAccount("yupi");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("1");
        user.setEmail("2");
        user.setUserStatus(0);
        user.setUserRole(0);
        user.setPlanetCode("3");

        boolean result = userService.save(user);
        System.out.printf("userId:%s", user.getId());
        Assert.isTrue(result, "失败");
    }
}