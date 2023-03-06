package com.example.meditation;

public class MaskFeeling {

    private  int id;
    private  String title;
    private  int position;
    private String image;


    public MaskFeeling(int id, String title, int position, String image) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.image = image;
    }

    public int getId() {
        return id;
    }
    public int getPosition() {
        return position;
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
    public void setPosition(int position) {
        this.position = position;
    }



}
