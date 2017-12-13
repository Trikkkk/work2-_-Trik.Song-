package com.trik.controller;

import com.trik.dao.UserMapper;
import com.trik.entity.User;
import com.trik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Controller
public class UserController {
    @Autowired
    private UserService userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    //注册页面
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    //登录页面
    @RequestMapping("/login")
    public String login() {
        return "login";
    }



    //注册方法
    @RequestMapping("/addregister")
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)) {
            User userEntity = new User();
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userMapper.insert(userEntity);
            return "login";
        } else {
            return "register";
        }
    }

    //登录方法
    @RequestMapping("/login1")
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.getSession().setAttribute("username",username);
        User usernameEntity = userMapper.findByUsername(username);
        String str = "";
        String password1 = "";

        //判断用户名是否对应
        if (usernameEntity != null) {
            password1 = usernameEntity.getPassword();;
            //判断密码是否对应
            if (password1.equals(password)) {
                str = "redirect:/text";

            }
        } else {
            //密码错误时执行的方法


            str = "redirect:/login";

        }
        return str;
    }
}








































