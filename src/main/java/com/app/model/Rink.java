package com.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 26.11.2016.
 */
public class Rink {

    private static final int N = 15;
    private List<Skater> skaters;

    public Rink(List<Skater> skaters){
        skaters = new ArrayList<>();
        this.skaters = skaters;
    }

    public static int getN() {
        return N;
    }

    public List<Skater> getSkaters() {
        //return new ArrayList<>(skaters);
        return skaters;
    }

    public void setSkaters(List<Skater> skaters) {
        this.skaters = skaters;
    }
}
