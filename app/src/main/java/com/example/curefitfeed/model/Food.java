package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("dish_title")
    @Expose
    private String dishTitle;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("calorie_count")
    @Expose
    private String calorieCount;
    @SerializedName("diet_type")
    @Expose
    private String dietType;
    @SerializedName("fitcash_amount")
    @Expose
    private String fitcashAmount;
    @SerializedName("actual_price")
    @Expose
    private String actualPrice;
    @SerializedName("discounted_price")
    @Expose
    private String discountedPrice;
    @SerializedName("cart")
    @Expose
    private String cart;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDishTitle() {
        return dishTitle;
    }

    public void setDishTitle(String dishTitle) {
        this.dishTitle = dishTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(String calorieCount) {
        this.calorieCount = calorieCount;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public String getFitcashAmount() {
        return fitcashAmount;
    }

    public void setFitcashAmount(String fitcashAmount) {
        this.fitcashAmount = fitcashAmount;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

}
