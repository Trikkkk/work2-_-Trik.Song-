package com.trik.dao;

import com.trik.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */


@Mapper
@Component
public interface UserMapper {

    public User findByUsername(String name);
    public List<User> getAll();
    public void update(User user);
    public void insert(User user);



}
