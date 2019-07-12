package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodDetail {

    @SerializedName("food_image")
    @Expose
    private String foodImage;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("food_title")
    @Expose
    private String foodTitle;
    @SerializedName("calories_value")
    @Expose
    private String caloriesValue;
    @SerializedName("protein_value")
    @Expose
    private String proteinValue;
    @SerializedName("fat_value")
    @Expose
    private String fatValue;
    @SerializedName("carbs_value")
    @Expose
    private String carbsValue;
    @SerializedName("food_detail")
    @Expose
    private String foodDetail;

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getCaloriesValue() {
        return caloriesValue;
    }

    public void setCaloriesValue(String caloriesValue) {
        this.caloriesValue = caloriesValue;
    }

    public String getProteinValue() {
        return proteinValue;
    }

    public void setProteinValue(String proteinValue) {
        this.proteinValue = proteinValue;
    }

    public String getFatValue() {
        return fatValue;
    }

    public void setFatValue(String fatValue) {
        this.fatValue = fatValue;
    }

    public String getCarbsValue() {
        return carbsValue;
    }

    public void setCarbsValue(String carbsValue) {
        this.carbsValue = carbsValue;
    }

    public String getFoodDetail() {
        return foodDetail;
    }

    public void setFoodDetail(String foodDetail) {
        this.foodDetail = foodDetail;
    }

}