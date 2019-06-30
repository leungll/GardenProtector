package com.nenusoftware.gardenprotector.controller.user;

import com.nenusoftware.gardenprotector.entity.user.User;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liangll
 * @Description:
 * @Date: 16:23 2019/5/22
 */
@CrossOrigin(allowCredentials = "true")
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public void login(String username, String password, HttpServletRequest request) throws Exception {
//        String username = "admin";
//        String password = "123";
        if(userService.selectByName(username)){
            if(userService.pwsIsTrue(username,password).size() != 0){
                HttpSession session = request.getSession();
                session.setAttribute("usernameSession",username);
                System.out.println("登录成功！");
            }else {
                System.out.println("您的密码有误！");
            }
        }else{
            System.out.println("用户名不存在，请去注册！");
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public List register (String username, String password) throws Exception{
        List list = new ArrayList();
        if(!userService.selectByName(username)){
            list.add(username);
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
        return list;
    }

    @RequestMapping("listAllUser")
    @ResponseBody
    public List<User> listAllArticle(){
        List<User> userList = null;
        try {
            userList = userService.listAllUser();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @RequestMapping("/listUserById")
    @ResponseBody
    public List<User> listUserById(HttpServletRequest request) throws Exception {
        List<User> userList = null;
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        userList = userService.listUser(userId);
        return userList;
    }

    @RequestMapping("/listUserArticle")
    @ResponseBody
    public List<User> listUserArticle(HttpServletRequest request) throws Exception {
        List<User> articleList = null;
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        articleList = userService.listUserArticle(userId);
        return articleList;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser( String userIdStr) throws Exception{
        int userId = Integer.parseInt(userIdStr);
        userService.deleteUser(userId);
        System.out.println("删除成功");
    }

    @RequestMapping("/exit")
    @ResponseBody
    public void exit(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.removeAttribute("usernameSession");
        System.out.println("退出成功");
    }

    @RequestMapping("file")
    public String file(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public void updateUser(String usernameStr, String imageStr, String sex, String birth, String locate, String job, String introduction, HttpServletRequest request) throws Exception{

//        if(file.isEmpty()){
//            System.out.println("文件不存在!");
//        }else{
//            String fileName = file.getOriginalFilename();
//            int size = (int) file.getSize();
//            System.out.println(fileName + "-->" + size);
//
//            //上传之后文件置于的路径
//            String URL = this.getClass().getClassLoader().getResource("static").toString();
//            URL = URL.replace("file:/","");
//            System.out.println(URL);
//            String path = URL;
//
//            File dest = new File(path + "/" + fileName);
//            //判断文件父目录是否存在
//            if(!dest.getParentFile().exists()){
//                dest.getParentFile().mkdir();
//            }
//            try{
//                //保存文件
//                file.transferTo(dest);

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();

//        int userId = 7;

        User user = new User();
        user.setId(userId);
        user.setUsername(usernameStr);
        user.setImage("http://47.103.10.220:8001/img/" + imageStr);
        user.setSex(sex);
        user.setBirth(birth);
        user.setLocate(locate);
        user.setJob(job);
        user.setIntroduction(introduction);

        userService.updateUser(user);
        System.out.println("修改个人信息成功");
    }

    @RequestMapping("/updatePower")
    @ResponseBody
    public void updatePower(String userIdStr) throws Exception {
        int userId = Integer.parseInt(userIdStr);
        userService.updatePower(userId);
        System.out.println("修改权限成功!");
    }

}
