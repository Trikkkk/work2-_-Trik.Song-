package com.trik.service;

import com.trik.entity.Comment;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/14.
 */
public interface CommentService {
    public List<Comment> findCommentById(Integer id);



   public  void insert(Integer commentid, String comment, String username);
}
