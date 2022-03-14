package com.better.nutritiontherapy;



public class Book {

    private String Title;
    private String Nutrients;
    private String Description ;
    private int Thumbnail ;

    public Book() {
    }

    public Book(String title, String nutrients, String description, int thumbnail) {
        Title = title;
        Nutrients= nutrients;
        Description = description;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }

    public String getNutrients() {
        return Nutrients;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setNutrients(String nutrients) {
        Nutrients= nutrients;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
