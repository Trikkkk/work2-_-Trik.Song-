package com.trik.dao;

import com.trik.entity.Text;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Mapper
@Component
public interface TextMapper {
    List<Text> getAll();
    Text findTextById(int id);
    void update(@Param("id")Integer id, @Param("content") String content);
    void delete(int id);
    List<Text> findTextByAuthor(String author);
    void insert(@Param("title")String title,@Param("author")String author, @Param("publishtime")Date publishtime, @Param("content") String content);
}
