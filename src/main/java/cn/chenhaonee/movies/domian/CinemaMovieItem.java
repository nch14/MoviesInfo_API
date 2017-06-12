package cn.chenhaonee.movies.domian;

/**
 * Created by chenhaonee on 2017/6/9.
 */
public class CinemaMovieItem {
    private String startAt;
    private String endAt;
    private String language;
    private String roomName;
    private String seatsNow;
    private String priceInNuomi;
    private String priceOriginInNuomi;

    private String priceInMaoyan;
    private String priceOriginInMaoyan;
    private String priceInTaopiaopiao;
    private String priceOriginInTaopiaopiao;

    public CinemaMovieItem() {
    }

    public CinemaMovieItem(String startAt, String endAt, String language, String roomName, String seatsNow, String priceInNuomi, String priceOriginInNuomi, String priceInMaoyan, String priceOriginInMaoyan, String priceInTaopiaopiao, String priceOriginInTaopiaopiao) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.language = language;
        this.roomName = roomName;
        this.seatsNow = seatsNow;
        this.priceInNuomi = priceInNuomi;
        this.priceOriginInNuomi = priceOriginInNuomi;
        this.priceInMaoyan = priceInMaoyan;
        this.priceOriginInMaoyan = priceOriginInMaoyan;
        this.priceInTaopiaopiao = priceInTaopiaopiao;
        this.priceOriginInTaopiaopiao = priceOriginInTaopiaopiao;
    }

    public String getStartAt() {

        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSeatsNow() {
        return seatsNow;
    }

    public void setSeatsNow(String seatsNow) {
        this.seatsNow = seatsNow;
    }

    public String getPriceInNuomi() {
        return priceInNuomi;
    }

    public void setPriceInNuomi(String priceInNuomi) {
        this.priceInNuomi = priceInNuomi;
    }

    public String getPriceInMaoyan() {
        return priceInMaoyan;
    }

    public void setPriceInMaoyan(String priceInMaoyan) {
        this.priceInMaoyan = priceInMaoyan;
    }

    public String getPriceInTaopiaopiao() {
        return priceInTaopiaopiao;
    }

    public void setPriceInTaopiaopiao(String priceInTaopiaopiao) {
        this.priceInTaopiaopiao = priceInTaopiaopiao;
    }

    public String getPriceOriginInNuomi() {
        return priceOriginInNuomi;
    }

    public void setPriceOriginInNuomi(String priceOriginInNuomi) {
        this.priceOriginInNuomi = priceOriginInNuomi;
    }

    public String getPriceOriginInMaoyan() {
        return priceOriginInMaoyan;
    }

    public void setPriceOriginInMaoyan(String priceOriginInMaoyan) {
        this.priceOriginInMaoyan = priceOriginInMaoyan;
    }

    public String getPriceOriginInTaopiaopiao() {
        return priceOriginInTaopiaopiao;
    }

    public void setPriceOriginInTaopiaopiao(String priceOriginInTaopiaopiao) {
        this.priceOriginInTaopiaopiao = priceOriginInTaopiaopiao;
    }
}
