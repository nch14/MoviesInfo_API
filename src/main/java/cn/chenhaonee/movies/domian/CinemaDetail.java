package cn.chenhaonee.movies.domian;

/**
 * Created by chenhaonee on 2017/6/11.
 */
public class CinemaDetail {

    private String key;
    private String value;

    public CinemaDetail() {
    }

    public CinemaDetail(String keyInt, String value) {
        this.key = keyInt;
        this.value = value;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
