package com.app.model;

/**
 * Created by prulov on 26.11.2016.
 */
public class Skater {

    private long id;

    public Skater(){}

    public Skater(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Skater # " + id;
    }
}
