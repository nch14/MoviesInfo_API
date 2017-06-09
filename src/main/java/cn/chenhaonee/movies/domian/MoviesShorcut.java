package cn.chenhaonee.movies.domian;

/**
 * Created by chenhaonee on 2017/6/9.
 */
public class MoviesShorcut {
    private String name;
    private String marksInNuomi;
    private String marksInMaoyan;
    private String marksInTaopiaopiao;
    private String imgUrl;
    private String id;

    public MoviesShorcut() {
    }

    public MoviesShorcut(String name, String marksInNuomi, String marksInMaoyan, String marksInTaopiaopiao, String imgUrl, String id) {

        this.name = name;
        this.marksInNuomi = marksInNuomi;
        this.marksInMaoyan = marksInMaoyan;
        this.marksInTaopiaopiao = marksInTaopiaopiao;
        this.imgUrl = imgUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
