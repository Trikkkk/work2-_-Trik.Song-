package com.trik.controller;

import com.trik.entity.Comment;
import com.trik.entity.Text;
import com.trik.service.CommentService;
import com.trik.service.TextService;
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

    @Autowired
    private TextService textService;


    /**
     *
     * 做出评论方法
     *
     */
    @RequestMapping("MakeComment")
    public String MakeComment(HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("username");
        Integer id = (Integer)request.getSession().getAttribute("id");
        String comment = request.getParameter("comment");
        commentService.insert(id,comment,username);
        //根据id来改text表中comment_num还有lastpublishnumber的值
        Text text=textService.findTextById(id);
        int num=text.getComment_num();
        num=num+1;
        text.setComment_num(num);
        Date lastpublishtime=new Date();
        System.out.println("time"+lastpublishtime);
        textService.update1(id,num,lastpublishtime);
        return "redirect:/text";
    }
}


