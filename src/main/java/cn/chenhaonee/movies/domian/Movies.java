package cn.chenhaonee.movies.domian;

/**
 * Created by chenhaonee on 2017/6/7.
 */
public class Movies {
    private String id;
    private String name;
    private String marksInNuomi;
    private String marksInMaoyan;
    private String marksInTaopiaopiao;    private String des;
    private String director;
    private String roles;
    private String country;
    private String length;
    private String time;
    private String content;

    public Movies() {
    }

    public Movies(String id, String name, String marksInNuomi, String marksInMaoyan, String marksInTaopiaopiao, String des, String director, String roles, String country, String length, String time, String content) {

        this.id = id;
        this.name = name;
        this.marksInNuomi = marksInNuomi;
        this.marksInMaoyan = marksInMaoyan;
        this.marksInTaopiaopiao = marksInTaopiaopiao;
        this.des = des;
        this.director = director;
        this.roles = roles;
        this.country = country;
        this.length = length;
        this.time = time;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarksInNuomi() {
        return marksInNuomi;
    }

    public void setMarksInNuomi(String marksInNuomi) {
        this.marksInNuomi = marksInNuomi;
    }

    public String getMarksInMaoyan() {
        return marksInMaoyan;
    }

    public void setMarksInMaoyan(String marksInMaoyan) {
        this.marksInMaoyan = marksInMaoyan;
    }

    public String getMarksInTaopiaopiao() {
        return marksInTaopiaopiao;
    }

    public void setMarksInTaopiaopiao(String marksInTaopiaopiao) {
        this.marksInTaopiaopiao = marksInTaopiaopiao;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
