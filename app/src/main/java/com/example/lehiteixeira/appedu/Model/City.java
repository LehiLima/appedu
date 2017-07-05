package com.example.lehiteixeira.appedu.Model;

import java.io.Serializable;

/**
 * Created by Lehi on 18/04/2017.
 */

public class City implements Serializable {

    private String title;

    public City(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
