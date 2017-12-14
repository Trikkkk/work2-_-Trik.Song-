package com.trik.controller;

import com.trik.entity.Comment;
import com.trik.entity.Text;
import com.trik.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Trik.Song on 2017/12/14.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    //做出评轮方法
    @RequestMapping("makecomment")
    public String makecomment(Integer id,String comment,String username,HttpServletRequest request){
        username = (String)request.getSession().getAttribute("username");
        id = (Integer)request.getSession().getAttribute("id");
        comment = request.getParameter("comment");
        System.out.println("111"+username);
        System.out.println("222"+id);
        System.out.println("333"+comment);
        commentService.insert(id,comment,username);
//根据id来改text表中comment_num还有lastpublishnumber的值

        
        return "redirect:/text";
    }


}


