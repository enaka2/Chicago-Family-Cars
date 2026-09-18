package com.example.project2;

import android.util.Pair;

import java.util.List;

public class Car {
    private String name;
    private int image;
    private String website;
    private List<Pair<String, String>> dealerships;

    public Car(String name, int image, String website, List<Pair<String, String>> dealerships) {
        this.name = name;
        this.image = image;
        this.website = website;
        this.dealerships = dealerships;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getWebsite() {
        return website;
    }

    public List<Pair<String, String>> getDealerships() {
        return dealerships;
    }
}