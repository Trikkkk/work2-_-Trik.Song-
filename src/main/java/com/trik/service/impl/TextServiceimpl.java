package com.trik.service.impl;

import com.trik.dao.TextMapper;
import com.trik.entity.Text;
import com.trik.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void update(String content){textMapper.update(content);}

    @Override
    public void delete(Integer id){textMapper.delete(id);}
}
