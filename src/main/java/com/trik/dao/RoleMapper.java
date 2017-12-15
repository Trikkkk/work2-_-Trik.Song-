package com.trik.dao;

import com.trik.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/15.
 */

@Mapper
@Component
public interface RoleMapper {

    /**
     *
     *显示Role表方法
     *
     */
    List<Role> getAll();
    /**
     *
     *通过name查询Role方法
     *
     */
    Role findRoleByName(String name);
    /**
     *
     *根据name更新权限power方法
     *
     */
    void update(@Param("name")String name, @Param("power") String power);
    /**
     *
     *根据name更新职业job方法
     *
     */
    void update_job(@Param("name")String name, @Param("job") String job);
}
