package com.example;

/**
 * Created by anup on 23/04/17.
 */
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

class Movie {
    private String title;
    private String imdbId;
    private String poster;
    private int year;

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @JsonSetter("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter("poster")
    public String getPoster() {
        return poster;
    }

    @JsonSetter("Poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JsonGetter("year")
    public int getYear() {
        return year;
    }

    @JsonSetter("Year")
    public void setYear(int year) {
        this.year = year;
    }

    @JsonGetter("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonSetter("imdbID")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}