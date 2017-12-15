package com.trik.dao;

import com.trik.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */


@Mapper
@Component
public interface UserMapper {

    /**
     *
     *通过name查询User方法
     *
     */
    public User findByUsername(String name);
    /**
     *
     *显示User方法
     *
     */
    public List<User> getAll();
    /**
     *
     *通过username更新attempt方法（把普通会员改成管理员）
     *
     */
    public void update(@Param("username")String username, @Param("attempt") Integer attempt);
    /**
     *
     *插入方法
     *
     */
    public void insert(User user);



}
