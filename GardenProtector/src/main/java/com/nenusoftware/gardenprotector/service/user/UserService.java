package com.nenusoftware.gardenprotector.service.user;

import com.nenusoftware.gardenprotector.entity.user.User;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/15 21:58
 */
public interface UserService {

    public boolean addUser(User user) throws Exception;

    public boolean updateUser(User user) throws Exception;

    public List<User> listUser(int id) throws Exception;

    public List<User> listUserArticle(int id) throws Exception;

    public boolean pwsIsTrue(String username, String password) throws Exception;

    public boolean selectByName(String username) throws Exception;

    public boolean deleteUser(int id) throws Exception;

    public boolean updatePower(int id) throws Exception;

}
