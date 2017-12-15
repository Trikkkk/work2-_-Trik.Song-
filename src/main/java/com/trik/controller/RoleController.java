package com.trik.controller;

import com.trik.entity.Role;
import com.trik.entity.Text;
import com.trik.entity.User;
import com.trik.service.RoleService;
import com.trik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Trik.Song on 2017/12/15.
 */
@Controller
public class RoleController {

   @Autowired
   private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     *
     *角色页面方法，将角色的数据库对象传到前端并显示
     *
     */
    @RequestMapping("/role")
    public String role(Model model) {
        List<Role> roles=roleService.getAll();
        model.addAttribute("roles",roles);
        return "role";
    }

    /**
     *
     *将页面传递至权限编辑页面并把前端的name属性传递
     *
     */
    @RequestMapping("/sendRole")
    public String sendRole(Model model,String name){
        Role roles=roleService.findRoleByName(name);
        model.addAttribute("roles",roles);
        return "editRole";
    }

    /**
     *
     *角色编辑方法
     *
     */
    @RequestMapping("/edit_Role")
    public String edit_Role(String name,HttpServletRequest request){
        String power=request.getParameter("power");
        roleService.update(name,power);

        return "redirect:role";
    }

    /**
     *
     *设置管理员成功时传递至成功页面
     *
     */
    @RequestMapping("/sendAdmin")
    public String sendAdmin(String name){
        int attempt=1;
        userService.update(name,attempt);
        String job="管理员";
        roleService.update_job(name,job);
        return "success";
    }

}
