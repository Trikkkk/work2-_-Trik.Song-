package com.trik.service;

import com.trik.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/15.
 */

public interface RoleService {
    public List<Role> getAll();

    Role findRoleByName(String name);

    public void update(String name,String power);

    public void update_job(String name, String job);
}
