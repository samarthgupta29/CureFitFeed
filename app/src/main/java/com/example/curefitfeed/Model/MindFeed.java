package com.example.curefitfeed.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MindFeed {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("headerInfo_1")
    @Expose
    private String headerInfo1;
    @SerializedName("whymindfit_details")
    @Expose
    private List<WhymindfitDetail> whymindfitDetails = null;
    @SerializedName("headerInfo_2")
    @Expose
    private String headerInfo2;
    @SerializedName("unlimitedmembership_details")
    @Expose
    private List<UnlimitedmembershipDetail> unlimitedmembershipDetails = null;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("first_month")
    @Expose
    private String firstMonth;
    @SerializedName("second_month_onwards")
    @Expose
    private String secondMonthOnwards;
    @SerializedName("workout_details")
    @Expose
    private List<WorkoutDetail> workoutDetails = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public List<WhymindfitDetail> getWhymindfitDetails() {
        return whymindfitDetails;
    }

    public void setWhymindfitDetails(List<WhymindfitDetail> whymindfitDetails) {
        this.whymindfitDetails = whymindfitDetails;
    }

    public String getHeaderInfo2() {
        return headerInfo2;
    }

    public void setHeaderInfo2(String headerInfo2) {
        this.headerInfo2 = headerInfo2;
    }

    public List<UnlimitedmembershipDetail> getUnlimitedmembershipDetails() {
        return unlimitedmembershipDetails;
    }

    public void setUnlimitedmembershipDetails(List<UnlimitedmembershipDetail> unlimitedmembershipDetails) {
        this.unlimitedmembershipDetails = unlimitedmembershipDetails;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(String firstMonth) {
        this.firstMonth = firstMonth;
    }

    public String getSecondMonthOnwards() {
        return secondMonthOnwards;
    }

    public void setSecondMonthOnwards(String secondMonthOnwards) {
        this.secondMonthOnwards = secondMonthOnwards;
    }

    public List<WorkoutDetail> getWorkoutDetails() {
        return workoutDetails;
    }

    public void setWorkoutDetails(List<WorkoutDetail> workoutDetails) {
        this.workoutDetails = workoutDetails;
    }

}
