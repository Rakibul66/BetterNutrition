package com.better.nutritiontherapy;

public class PostModel {

    String title, blog, category, picture, id, uid, likes, views, date;
    long time;

    public PostModel() {
    }

    public PostModel(String title, String blog, String category, String picture, String id, String uid, String likes, String views, String date, long time) {
        this.title = title;
        this.blog = blog;
        this.category = category;
        this.picture = picture;
        this.id = id;
        this.uid = uid;
        this.likes = likes;
        this.views = views;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getBlog() {
        return blog;
    }

    public String getCategory() {
        return category;
    }

    public String getPicture() {
        return picture;
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public String getLikes(){
        return likes;
    }

    public String getViews(){
        return views;
    }

    public String getDate() {
        return date;
    }

    public long getTime() {
        return time;
    }
}