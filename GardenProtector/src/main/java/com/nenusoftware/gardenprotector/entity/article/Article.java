package com.nenusoftware.gardenprotector.entity.article;

/**
 * @author : kongyy
 * @time : 2019/5/13 21:40
 */
public class Article {

    private Integer id;

    private String title;

    private String author;

    private Integer user_id;

    private String content;

    private String createtime;

    private Integer liked;

    private String types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer like) {
        this.liked = like;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", liked=" + liked +
                ", types=" + types +
                '}';
    }
}
