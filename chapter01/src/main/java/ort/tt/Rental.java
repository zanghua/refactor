package ort.tt;

/**
 * Created by zangzhonghua on 2017/4/21.
 * 表示顾客租了影片
 */
public class Rental {
    private Movie movie;
    private int days;

    public Rental(int days, Movie movie) {
        this.days = days;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDays() {
        return days;
    }
}
