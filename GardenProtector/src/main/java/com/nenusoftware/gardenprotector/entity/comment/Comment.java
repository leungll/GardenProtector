package com.nenusoftware.gardenprotector.entity.comment;

/**
 * @author : kongyy
 * @time : 2019/5/13 21:54
 */
public class Comment {

    private Integer id;

    private Integer article_id;

    private Integer user_id;

    private String author;

    private String content;

    private Integer liked;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
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
        return "Comment{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", user_id=" + user_id +
                ", author='" + author + '\'' +
                ", commentContent='" + content + '\'' +
                ", liked=" + liked +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
