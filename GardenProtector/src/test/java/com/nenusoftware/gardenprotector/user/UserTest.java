package com.nenusoftware.gardenprotector.user;

import com.nenusoftware.gardenprotector.entity.user.User;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/16 9:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testAddUser() throws Exception{
        User user = new User();
        user.setUsername("lucy");
        user.setPassword("123");
        user.setSex("女");
        user.setImage("aaaaaaa");
        user.setBirth("19991021");
        user.setIntroduction("我是小仙女");
        user.setJob("软件狗");
        user.setLocate("henan");
        userService.addUser(user);
    }

    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setUsername("lucy啊");
        user.setPassword("123");
        user.setSex("女");
        user.setImage("aaaaaaa");
        user.setBirth("19991021");
        user.setIntroduction("我不是小仙女");
        user.setJob("软件狗");
        user.setLocate("henan");
        user.setId(2);
        userService.updateUser(user);
    }

    @Test
    public void testListUser() throws Exception{
        System.out.println(userService.listUser(1));
    }

    @Test
    public void testListUserArticle() throws Exception{
        System.out.println(userService.listUserArticle(3));
    }

    @Test
    public void testSelectByName() throws Exception{
        String username = "孔一言";
        System.out.println(userService.selectByName(username));
    }

    @Test
    public void testDeleteUser() throws Exception{
        int id = 2;
        System.out.println(userService.deleteUser(id));
    }

    @Test
    public void testUpdatePower() throws Exception{
        int id = 1;
        System.out.println(userService.updatePower(id));
    }
}
