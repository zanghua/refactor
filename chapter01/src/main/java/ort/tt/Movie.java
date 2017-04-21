package ort.tt;

/**
 * Created by zangzhonghua on 2017/4/21.
 */
public class Movie {
    //影片类型：儿童片、普通片、新片
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 0;

    //影片名称
    private String title;
    //类型
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
