package com.trik.service.impl;

import com.trik.dao.UserMapper;
import com.trik.entity.User;
import com.trik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Service
public class UserServieceimpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String name){return userMapper.findByUsername(name);}

    @Override
    public List<User> getAll(){return userMapper.getAll();}

    @Override
    public void update(String username,Integer attempt){userMapper.update(username,attempt);}

    @Override
    public void insert(User user){userMapper.insert(user);}

}
