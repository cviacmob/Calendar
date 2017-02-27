package com.cviac.calendar.datamodel;

import java.io.Serializable;

public class WonderModel implements Serializable {

    String cardName;
    String description;
    int imageResourceId;
    int isfav;
    int isturned;
    String place;
    String date;
    String android_image_url;
    String about;
    String cost;
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }



    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }



    public WonderModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAndroid_image_url() {
        return android_image_url;
    }

    public int getIsturned() {
        return isturned;
    }

    public void setIsturned(int isturned) {
        this.isturned = isturned;
    }

    public int getIsfav() {
        return isfav;
    }

    public void setIsfav(int isfav) {
        this.isfav = isfav;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setplace(String place) {
        this.place = place;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getdate() {
        return date;
    }

    public String getplace() {
        return place;
    }


    public void setAndroid_image_url(String android_image_url) {
        this.android_image_url = android_image_url;
    }
}




