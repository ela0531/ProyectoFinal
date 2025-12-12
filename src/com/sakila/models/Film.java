
package com.sakila.models;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private Integer id;
    private String title;
    private int year;
    private String genre;
    private List<Actor> actors = new ArrayList<>();

    public Film() {}

    public Film(Integer id, String title, int year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public List<Actor> getActors() { return actors; }
    public void setActors(List<Actor> actors) { this.actors = actors; }
}
