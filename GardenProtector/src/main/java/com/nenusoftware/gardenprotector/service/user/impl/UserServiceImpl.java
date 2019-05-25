package com.nenusoftware.gardenprotector.service.user.impl;

import com.nenusoftware.gardenprotector.entity.user.User;
import com.nenusoftware.gardenprotector.mapper.user.UserMapper;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/15 21:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) throws Exception{
        return userMapper.addUser(user);
    }

    @Override
    public boolean updateUser(User user) throws Exception{
        return userMapper.updateUser(user);
    }

    @Override
    public boolean pwsIsTrue(String username, String password) throws Exception{
        return userMapper.pwsIsTrue(username,password);
    }

    @Override
    public List<User> listUser(int id) throws Exception{
        List<User> listUser = Collections.emptyList();
        listUser = userMapper.listUser(id);
        return listUser;
    }

    @Override
    public List<User> listUserArticle(int id) throws Exception{
        List<User> listArticle = Collections.emptyList();
        listArticle = userMapper.listUserArticle(id);
        return listArticle;
    }

    @Override
    public boolean selectByName(String username) throws Exception{
        boolean flag = false;
        List<User> list = Collections.emptyList();
        list = userMapper.selectByName(username);
        if(list.size() != 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) throws Exception{
        return userMapper.deleteUser(id);
    }

    @Override
    public boolean updatePower(int id) throws Exception{
        return userMapper.updatePower(id);
    }
}
