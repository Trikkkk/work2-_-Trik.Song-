package com.trik.controller;

import com.trik.dao.CommentMapper;
import com.trik.dao.TextMapper;
import com.trik.entity.Comment;
import com.trik.entity.Role;
import com.trik.entity.Text;

import com.trik.service.CommentService;
import com.trik.service.RoleService;
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

    @Autowired
    private RoleService roleMapper;

    /**
     *
     *显示管理员的文章列表
     *
     */
    @RequestMapping("/text")
    public String Text(Model model) {
    List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "text";
    }
    /**
     *
     *显示普通会员的文章列表
     *
     */
    @RequestMapping("/memberText")
    public String memberText(Model model) {
        List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "memberText";
    }

    /**
     *
     *传递至查看详情页面
     *
     */
    @RequestMapping("/send")
    public String send(HttpServletRequest request,Model model, Integer id){
        Text texts=textMapper.findTextById(id);
        model.addAttribute("texts",texts);
        request.getSession().setAttribute("id",id);
        List<Comment> comments=commentMapper.findCommentById(id);
        model.addAttribute("comments",comments);
        return "myText";
    }


    /**
     *
     *显示消息页面
     *
     */
    @RequestMapping("/showMessage")
    public String showMessage(Model model) {
        List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "showMessage";
    }

    /**
     *
     *将消息页面的编辑传送至编辑页面
     *
     */
    @RequestMapping("/send1")
    public String send1(Model model,Integer id,HttpServletRequest request){
        request.getSession().setAttribute("id_text",id);
        Text texts=textMapper.findTextById(id);
        model.addAttribute("texts",texts);
        return "message";
    }

    /**
     *
     *非会员的消息传送页面
     *
     */
    @RequestMapping("/send2")
    public String send2(Model model,String author){
        List<Text> texts=textMapper.findTextByAuthor(author);
        model.addAttribute("texts",texts);
        return "showMemberMessage";
    }


    /**
     *
     *无权限页面
     *
     */
    @RequestMapping("/noPower")
    public String noPower() {
        return "noPower";
    }

    /**
     *
     *普通会员的无权限页面
     *
     */
    @RequestMapping("/memberNoPower")
    public String memberNoPower(){return "memberNoPower";}

    /**
     *
     *消息的编辑方法
     *
     */
    @RequestMapping("/edit")
    public String edit(Integer id,String content,HttpServletRequest request) {

        String name=(String)request.getSession().getAttribute("username");
        Role role=roleMapper.findRoleByName(name);
        String power=role.getPower();
        int attempt;
        attempt = (Integer) request.getSession().getAttribute("attempt");

        if(power.equals("ed")||power.equals("e")){
        id = (Integer) request.getSession().getAttribute("id_text");
        content = request.getParameter("content");
        textMapper.update(id, content);
        if (attempt == 1) {
            return "redirect:/showMessage";
        } else {
             return "redirect:/memberText";
        }
        }else{
            if(attempt==1){
            return "redirect:/noPower";}
            else {
                return "redirect:/memberNoPower";
            }
            }
        }


    /**
     *
     *消息的删除方法
     *
     */
    @RequestMapping("/delete")
    public String delete(Integer id,HttpServletRequest request) {
        String name=(String)request.getSession().getAttribute("username");
        Role role=roleMapper.findRoleByName(name);
        int attempt;
        attempt = (Integer) request.getSession().getAttribute("attempt");
        String power=role.getPower();
        if(power.equals("ed")||power.equals("e")){
        textMapper.delete(id);
        if(attempt==1)
        {return "redirect:/showMessage";}else{
        return "redirect:/memberText";}
        }
        else {
            if (attempt == 1) {
                return "redirect:/noPower";
            } else {
                return "redirect:/memberNoPower";
            }
             }
        }


    /**
     *
     *新增文章页面
     *
     */
    @RequestMapping("/insertMessage")
    public String insertMessage() {

        return "insertMessage";
    }

    /**
     *
     *新增文章方法
     *
     */
    @RequestMapping("insertMsg")
    public String insertMsg(HttpServletRequest request){
        String author=(String)request.getSession().getAttribute("username");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        Date publishtime=new Date();
        textMapper.insert(title,author,publishtime,content);

        return "redirect:/memberText";
    }



}
