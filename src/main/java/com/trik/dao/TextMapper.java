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
    /**
     *
     *显示Text方法
     *
     */
    List<Text> getAll();
    /**
     *
     *通过id查询Text方法
     *
     */
    Text findTextById(int id);
    /**
     *
     *通过Id更新内容方法
     *
     */
    void update(@Param("id")Integer id, @Param("content") String content);
    /**
     *
     *删除方法
     *
     */
    void delete(int id);
    /**
     *
     *通过作者查询Text方法
     *
     */
    List<Text> findTextByAuthor(String author);
    /**
     *
     *插入方法
     *
     */
    void insert(@Param("title")String title,@Param("author")String author, @Param("publishtime")Date publishtime, @Param("content") String content);
    /**
     *
     *通过id更新评论数和最后评论时间方法
     *
     */
    void update1(@Param("id")Integer id, @Param("comment_num") Integer comment_num,@Param("lastpublishtime")Date lastpublishtime);

}
