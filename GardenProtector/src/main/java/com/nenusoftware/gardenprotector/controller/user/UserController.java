package com.nenusoftware.gardenprotector.controller.user;

import com.nenusoftware.gardenprotector.entity.user.User;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Liangll
 * @Description:
 * @Date: 16:23 2019/5/22
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) throws Exception {
        if(userService.selectByName(username)){
            if(userService.pwsIsTrue(username,password).size()!= 0){
                HttpSession session = request.getSession();
                session.setAttribute("usernameSession",username);
                System.out.println("登录成功！");
            }else {
                System.out.println("您的密码有误！");
            }
        }else{
            System.out.println("用户名不存在，请去注册！");
        }
        return username;
    }

    @RequestMapping("/register")
    public String register (String username, String password) throws Exception{
        if(!userService.selectByName(username)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPower(0);
            if(userService.addUser(user)){
                System.out.println("注册成功！");
            }
        }else{
            System.out.println("用户名已存在，请直接登录！");
        }
        return username;
    }

    @RequestMapping("/listUserById")
    public List<User> listUserById(HttpServletRequest request) throws Exception {
        List<User> userList = null;
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        userList = userService.listUser(userId);
        return userList;
    }

    @RequestMapping("/listUserArticle")
    public List<User> listUserArticle(HttpServletRequest request) throws Exception {
        List<User> articleList = null;
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        articleList = userService.listUserArticle(userId);
        return articleList;
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        userService.deleteUser(userId);
        System.out.println("注销成功");
    }
}
