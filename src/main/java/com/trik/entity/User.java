package com.trik.entity;

import java.util.Date;

/**
 * Created by Trik.Song on 2017/12/12.
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer attempt;
    private Date time;


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
