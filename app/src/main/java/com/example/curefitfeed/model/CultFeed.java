package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CultFeed {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("headerInfo_1")
    @Expose
    private String headerInfo1;
    @SerializedName("headerInfo_2")
    @Expose
    private String headerInfo2;
    @SerializedName("headerInfo_3")
    @Expose
    private String headerInfo3;
    @SerializedName("cultunlimitedmembership_details")
    @Expose
    private List<CultunlimitedmembershipDetail> cultunlimitedmembershipDetails = null;
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
    @SerializedName("headerInfo_4")
    @Expose
    private String headerInfo4;
    @SerializedName("cultselectmembership_details")
    @Expose
    private List<CultselectmembershipDetail> cultselectmembershipDetails = null;
    @SerializedName("whycultfit_details")
    @Expose
    private List<WhycultfitDetail> whycultfitDetails = null;
    @SerializedName("cultworkout_details")
    @Expose
    private List<CultworkoutDetail> cultworkoutDetails = null;
    @SerializedName("trainer_details")
    @Expose
    private List<TrainerDetail> trainerDetails = null;

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

    public String getHeaderInfo2() {
        return headerInfo2;
    }

    public void setHeaderInfo2(String headerInfo2) {
        this.headerInfo2 = headerInfo2;
    }

    public String getHeaderInfo3() {
        return headerInfo3;
    }

    public void setHeaderInfo3(String headerInfo3) {
        this.headerInfo3 = headerInfo3;
    }

    public List<CultunlimitedmembershipDetail> getCultunlimitedmembershipDetails() {
        return cultunlimitedmembershipDetails;
    }

    public void setCultunlimitedmembershipDetails(List<CultunlimitedmembershipDetail> cultunlimitedmembershipDetails) {
        this.cultunlimitedmembershipDetails = cultunlimitedmembershipDetails;
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

    public String getHeaderInfo4() {
        return headerInfo4;
    }

    public void setHeaderInfo4(String headerInfo4) {
        this.headerInfo4 = headerInfo4;
    }

    public List<CultselectmembershipDetail> getCultselectmembershipDetails() {
        return cultselectmembershipDetails;
    }

    public void setCultselectmembershipDetails(List<CultselectmembershipDetail> cultselectmembershipDetails) {
        this.cultselectmembershipDetails = cultselectmembershipDetails;
    }

    public List<WhycultfitDetail> getWhycultfitDetails() {
        return whycultfitDetails;
    }

    public void setWhycultfitDetails(List<WhycultfitDetail> whycultfitDetails) {
        this.whycultfitDetails = whycultfitDetails;
    }

    public List<CultworkoutDetail> getCultworkoutDetails() {
        return cultworkoutDetails;
    }

    public void setCultworkoutDetails(List<CultworkoutDetail> cultworkoutDetails) {
        this.cultworkoutDetails = cultworkoutDetails;
    }

    public List<TrainerDetail> getTrainerDetails() {
        return trainerDetails;
    }

    public void setTrainerDetails(List<TrainerDetail> trainerDetails) {
        this.trainerDetails = trainerDetails;
    }

}
