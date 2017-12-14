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

    public List<Comment> findCommentById(int id);

    public  void insert(@Param("commentid")Integer commentid,@Param("comment") String comment,@Param("username") String username);
}
