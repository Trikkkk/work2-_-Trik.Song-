package com.trik.service.impl;

import com.trik.dao.TextMapper;
import com.trik.entity.Text;
import com.trik.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Service
public class TextServiceimpl implements TextService {
    @Autowired
    private TextMapper textMapper;

    @Override
    public List<Text> getAll(){return textMapper.getAll();}

    @Override
    public Text findTextById(Integer id){return textMapper.findTextById(id);}

    @Override
    public void update(Integer id,String content){textMapper.update(id,content);}

    @Override
    public void delete(Integer id){textMapper.delete(id);}

    @Override
    public List<Text> findTextByAuthor(String author){return textMapper.findTextByAuthor(author);}

    @Override
    public void insert(String title,String author,Date publishtime,String content){textMapper.insert(title,author,publishtime,content);}
}
