package com.trik.entity;

import java.util.Date;

/**
 * Created by Trik.Song on 2017/12/12.
 */
public class User {
    private Long id;        //用户的主键id
    private String username;//用户名
    private String password;//密码
    private Integer attempt;//判断用户是否为管理员，0是普通会员，1是管理员
    private Date time;      //时间


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Date getLogintime(){return time;}

    public void setLogintime(Date time){
        this.time=time;
    }

}
