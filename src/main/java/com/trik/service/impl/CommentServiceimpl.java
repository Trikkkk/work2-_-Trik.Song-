package com.trik.service.impl;

import com.trik.dao.CommentMapper;
import com.trik.entity.Comment;
import com.trik.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/14.
 */

@Service
public class CommentServiceimpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentById(Integer id){return commentMapper.findCommentById(id);}

    @Override
    public void insert(Integer commentid, String comment, String username) {commentMapper.insert(commentid,comment,username);
    }
}
