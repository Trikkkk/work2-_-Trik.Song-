package com.trik.service;

import com.trik.entity.User;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */
public interface UserService {
    public User findByUsername(String name);
    public List<User> getAll();
    public void update(User user);
    public void insert(User user);
}
