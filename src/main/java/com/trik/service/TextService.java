package com.trik.service;

import com.trik.entity.Text;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */
public interface TextService {
    public List<Text> getAll();

    Text findTextById(Integer id);

    public  void update(Integer id,String content);

    public void delete(Integer id);

    public List<Text> findTextByAuthor(String author);

    void insert(String title,String author, Date publishtime, String content);
}
