package com.trik.dao;

import com.trik.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/14.
 */

@Mapper
@Component
public interface CommentMapper {

    /**
     *
     *通过id查询评论
     *
     */
    public List<Comment> findCommentById(int id);

    /**
     *
     *插入方法
     *
     */
    public  void insert(@Param("commentid")Integer commentid,@Param("comment") String comment,@Param("username") String username);
}
