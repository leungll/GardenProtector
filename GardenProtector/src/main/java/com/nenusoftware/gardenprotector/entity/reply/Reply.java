package com.nenusoftware.gardenprotector.entity.reply;

/**
 * @author : kongyy
 * @time : 2019/5/14 18:31
 */
public class Reply {

    private Integer id;

    private Integer user_id;

    private String author;

    private Integer replycomment_id;

    private String content;

    private Integer liked;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getReplycomment_id() {
        return replycomment_id;
    }

    public void setReplycomment_id(Integer replycomment_id) {
        this.replycomment_id = replycomment_id;
    }

    public Integer getReplyuser_id() {
        return replycomment_id;
    }

    public void setReplyuser_id(Integer replyuser_id) {
        this.replycomment_id = replyuser_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", author='" + author + '\'' +
                ", replycomment_id=" + replycomment_id +
                ", content='" + content + '\'' +
                ", liked=" + liked +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
