package com.example.moviewuitemplate.models;

public class Cast {
    private String name;
    private int imgLink;

    public Cast(String name, int imgLink) {
        this.name = name;
        this.imgLink = imgLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgLink() {
        return imgLink;
    }

    public void setImgLink(int imgLink) {
        this.imgLink = imgLink;
    }
}
