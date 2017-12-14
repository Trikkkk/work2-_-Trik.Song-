package com.trik.entity;

/**
 * Created by Trik.Song on 2017/12/14.
 */
public class Comment {
    private Integer id;
    private Integer commentid;
    private String comment;
    private String username;

    public Integer getId(){return id;}

    public void setId(Integer id){this.id = id;}

   public Integer getCommentid(){return commentid;}

    public void setCommentid(Integer commentid){this.commentid = commentid;}

    public String getComment(){return comment;}

    public void setComment(String comment){this.comment = comment;}

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}
}
