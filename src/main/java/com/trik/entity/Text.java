package com.trik.entity;

import java.util.Date;

/**
 * Created by Trik.Song on 2017/12/12.
 */
public class Text {
    private Integer id;
    private String title;
    private String author;
    private Date publishtime;
    private Integer comment_num;
    private Date lastpublishtime;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getAuthor(){return author;}

    public void setAuthor(String author){this.author = author;}

    public Date getPublishtime(){return publishtime;}

    public void setPublishtime(Date publishtime){this.publishtime = publishtime;}

    public Integer getComment_num(){return comment_num;}

    public void setComment_num(Integer comment_num){this.comment_num = comment_num;}

    public Date getLastpublishtime(){return lastpublishtime;}

    public void setLastpublishtime(Date lastpublishtime){this.lastpublishtime = lastpublishtime;}

    public String getContent(){return content;}

    public void setContent(String content){this.content = content;}
}
