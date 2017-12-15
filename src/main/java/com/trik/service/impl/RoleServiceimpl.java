package com.trik.service.impl;

import com.trik.dao.RoleMapper;
import com.trik.entity.Role;
import com.trik.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/15.
 */
@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAll(){return roleMapper.getAll();}

    @Override
    public  Role findRoleByName(String name){return roleMapper.findRoleByName(name);}

    @Override
    public void update(String name,String power){roleMapper.update(name,power);}

    @Override
    public void update_job(String name,String job){roleMapper.update_job(name,job);}


}
