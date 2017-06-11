package cn.chenhaonee.movies.domian;

/**
 * Created by chenhaonee on 2017/6/9.
 */
public class Cinemas {
    private String id;
    private String name;
    private String address;
    private String lowestPriceInNuomi;
    private String lowestPriceInMaoyan;
    private String lowestPriceInTaopiaopiao;

    public Cinemas() {
    }

    public Cinemas(String id, String name, String address, String lowestPriceInNuomi, String lowestPriceInMaoyan, String lowestPriceInTaopiaopiao) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.lowestPriceInNuomi = lowestPriceInNuomi;
        this.lowestPriceInMaoyan = lowestPriceInMaoyan;
        this.lowestPriceInTaopiaopiao = lowestPriceInTaopiaopiao;
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

    public String getLowestPriceInNuomi() {
        return lowestPriceInNuomi;
    }

    public void setLowestPriceInNuomi(String lowestPriceInNuomi) {
        this.lowestPriceInNuomi = lowestPriceInNuomi;
    }

    public String getLowestPriceInMaoyan() {
        return lowestPriceInMaoyan;
    }

    public void setLowestPriceInMaoyan(String lowestPriceInMaoyan) {
        this.lowestPriceInMaoyan = lowestPriceInMaoyan;
    }

    public String getLowestPriceInTaopiaopiao() {
        return lowestPriceInTaopiaopiao;
    }

    public void setLowestPriceInTaopiaopiao(String lowestPriceInTaopiaopiao) {
        this.lowestPriceInTaopiaopiao = lowestPriceInTaopiaopiao;
    }
}
