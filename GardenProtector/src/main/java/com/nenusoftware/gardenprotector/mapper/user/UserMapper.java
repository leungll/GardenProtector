package com.nenusoftware.gardenprotector.mapper.user;

import com.nenusoftware.gardenprotector.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/15 21:53
 */
@Mapper
@Repository
public interface UserMapper {

    public boolean addUser(@Param("user") User user) throws Exception;

    public boolean updateUser(@Param("user") User user) throws Exception;

    public List<User> listUser(@Param("id") int id) throws Exception;

    public List<User> listUserArticle(@Param("id") int id) throws Exception;

    public boolean pwsIsTrue(@Param("username") String username, @Param("password") String password) throws Exception;

    public List<User> selectByName(@Param("username")String username) throws Exception;

    public boolean deleteUser(@Param("id") int id) throws Exception;

    public boolean updatePower(@Param("id") int id) throws Exception;
}
