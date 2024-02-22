package com.epitech.redditech.Models.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("name")
    @Expose
    private String userName;
    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("coins")
    @Expose
    private int coins;
    @SerializedName("total_karma")
    @Expose
    private int totalKarma;
    @SerializedName("description")
    @Expose
    private String description;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getTotalKarma() {
        return totalKarma;
    }

    public void setTotalKarma(int totalKarma) {
        this.totalKarma = totalKarma;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
