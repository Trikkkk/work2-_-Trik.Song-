package com.trik.entity;

/**
 * Created by Trik.Song on 2017/12/15.
 */
public class Role {

    private Integer id;   //角色的主键id字段
    private String name;  //角色的名字，和text还有user里的名字对应
    private String power; //角色的权限
    public String job;    //角色的职位

    public Integer getId(){return id;}

    public void setId(Integer id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getPower(){return power;}

    public void setPower(String power){this.power = power;}

    public String getJob(){return job;}

    public void setJob(String job){this.job = job;}

}
