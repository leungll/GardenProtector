package com.nenusoftware.gardenprotector.entity.adoption;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:14
 */
public class Adoption {

    private Integer id;

    private Integer user_id;

    private String city;

    private String types;

    private String detail;

    private String note;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Adoption{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", city='" + city + '\'' +
                ", type='" + types + '\'' +
                ", detail='" + detail + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
