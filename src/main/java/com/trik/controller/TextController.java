package com.trik.controller;

import com.trik.dao.CommentMapper;
import com.trik.dao.TextMapper;
import com.trik.entity.Comment;
import com.trik.entity.Text;

import com.trik.service.CommentService;
import com.trik.service.TextService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Controller
public class TextController {

    @Autowired
    private TextService textMapper;

    @Autowired
    private CommentService commentMapper;

    //显示文章列表
    @RequestMapping("/text")
    public String Text(Model model) {
    List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "text";
    }
    //显示非会员文章列表
    @RequestMapping("/membertext")
    public String membertext(Model model) {
        List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "membertext";
    }

    //传送到查看详情页面
    @RequestMapping("/send")
    public String send(HttpServletRequest request,Model model, Integer id){
        Text texts=textMapper.findTextById(id);
        model.addAttribute("texts",texts);
        request.getSession().setAttribute("id",id);
        List<Comment> comments=commentMapper.findCommentById(id);
        model.addAttribute("comments",comments);
        return "mytext";
    }


    //消息页面
    @RequestMapping("/showmessage")
    public String showmessage(Model model) {
        List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "showmessage";
    }
    //将消息页面的编辑传递到修改页
    @RequestMapping("/send1")
    public String send1(Model model,Integer id,HttpServletRequest request){
        request.getSession().setAttribute("id_text",id);
        Text texts=textMapper.findTextById(id);
        model.addAttribute("texts",texts);
        return "message";
    }

    //非会员的传送页面
    @RequestMapping("/send2")
    public String send2(Model model,String author){
        List<Text> texts=textMapper.findTextByAuthor(author);
        model.addAttribute("texts",texts);
        return "showmembermessage";
    }


    //编辑方法
    @RequestMapping("/edit")
    public String edit(Integer id,String content,HttpServletRequest request) {
        id = (Integer) request.getSession().getAttribute("id_text");
        content = request.getParameter("content");
        System.out.println("id是" + id);
        System.out.println("content是" + content);
        textMapper.update(id, content);
        int attempt;
        attempt = (Integer) request.getSession().getAttribute("attempt");
        System.out.println("attempts是"+attempt);
        if (attempt == 1) {
            return "redirect:/showmessage";
        } else {
             return "redirect:/membertext";
        }
    }

    //删除方法
    @RequestMapping("/delete")
    public String delete(Integer id) {
        textMapper.delete(id);
        return "redirect:/showmessage";
    }

    //新增文章页面
    @RequestMapping("/insertmessage")
    public String insertmessage() {

        return "insertmessage";
    }

    //新增文章方法
    @RequestMapping("insertMsg")
    public String insertMsg(HttpServletRequest request){
        String author=(String)request.getSession().getAttribute("username");
        System.out.println("author是是是"+author);
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        Date publishtime=new Date();
        textMapper.insert(title,author,publishtime,content);

        return "redirect:/membertext";
    }



}
