package com.nenusoftware.gardenprotector.entity.user;

/**
 * @author : kongyy
 * @time : 2019/5/15 21:47
 */
public class User {

    private Integer id;

    private String username;

    private String password;

    private String image;

    private String sex;

    private String birth;

    private String locate;

    private String job;

    private String introduction;

    private String title;

    private String author;

    private Integer user_id;

    private String content;

    private String createtime;

    private Integer liked;

    private Integer power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public void setLiked(Integer liked) {
        this.liked = liked;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", locate='" + locate + '\'' +
                ", job='" + job + '\'' +
                ", introduction='" + introduction + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", liked=" + liked +
                ", power=" + power +
                '}';
    }
}
