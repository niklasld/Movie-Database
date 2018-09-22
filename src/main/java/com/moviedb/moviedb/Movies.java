package com.moviedb.moviedb;

public class Movies {

    private int id, year;
    private String movieTitle, link, genre, pictureLink;
    private double duration;

    public Movies() {
    }

    public Movies(int id, int year, String movieTitle, String link, String genre, double duration, String pictureLink) {
        this.id = id;
        this.year = year;
        this.movieTitle = movieTitle;
        this.link = link;
        this.genre = genre;
        this.duration = duration;
        this.pictureLink = pictureLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", year=" + year +
                ", movieTitle='" + movieTitle + '\'' +
                ", link='" + link + '\'' +
                ", genre='" + genre + '\'' +
                ", pictureLink='" + pictureLink + '\'' +
                ", duration=" + duration +
                '}';
    }
}
