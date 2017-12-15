package com.trik.entity;

/**
 * Created by Trik.Song on 2017/12/14.
 */
public class Comment {

    private Integer id;       //主键id字段，自动生成
    private Integer commentid;//评论的id字段，和Text的id绑定
    private String comment;   //评论内容
    private String username;  //评论的用户名

    public Integer getId(){return id;}

    public void setId(Integer id){this.id = id;}

   public Integer getCommentid(){return commentid;}

    public void setCommentid(Integer commentid){this.commentid = commentid;}

    public String getComment(){return comment;}

    public void setComment(String comment){this.comment = comment;}

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}
}
