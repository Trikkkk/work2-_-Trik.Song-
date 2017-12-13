package com.trik.controller;

import com.trik.dao.TextMapper;
import com.trik.entity.Text;
import com.trik.service.TextService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Controller
public class TextController {

    @Autowired
    private TextService textMapper;

    //显示文章列表
    @RequestMapping("/text")
    public String Text(Model model) {
    List<Text> texts=textMapper.getAll();
        model.addAttribute("texts",texts);
        return "text";
    }
    //传送到查看详情页面
    @RequestMapping("/send")
    public String send(Model model,Integer id){
        Text texts=textMapper.findTextById(id);
        model.addAttribute("texts",texts);
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
    public String send1(Model model,Integer id){
        Text texts=textMapper.findTextById(id);
        model.addAttribute("texts",texts);
        return "message";
    }
    //编辑方法
    @RequestMapping("/edit")
    public String edit(String content){
        textMapper.update(content);
        return "redirect:/showmessage";
    }
    //删除方法
    @RequestMapping("/delete")
    public String delete(Integer id) {
        textMapper.delete(id);
        return "redirect:/showmessage";
    }

    }
