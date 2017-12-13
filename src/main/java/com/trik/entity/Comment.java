package com.trik.entity;

/**
 * Created by Trik.Song on 2017/12/13.
 */
public class Comment {
    private Integer commentid;
    private Integer texitid;
    private String comment;
    private String username;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getTexitid(){return texitid;}

    public void setTexitid(Integer texitid){this.texitid = texitid;}

    public String getComment(){return comment;}

    public void setComment(String comment){this.comment = comment;}

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}

}
