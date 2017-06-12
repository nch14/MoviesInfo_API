package cn.chenhaonee.movies.domian;

/**
 * Created by chenhaonee on 2017/6/9.
 */
public class Cinemas {
    private String id;
    private String name;
    private String address;
    private String lowestPrice;
    private String tel;

    public Cinemas() {
    }

    public Cinemas(String id, String name, String address, String lowestPrice, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lowestPrice = lowestPrice;
        this.tel = tel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
