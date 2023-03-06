package com.example.meditation;

public class MaskQuote {

    private  int id;
    private  String title;
    private String image;
    private  String description;



    public MaskQuote(int id, String title, String image, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}