package com.example.curefitfeed.Model;

public class MindMonthlySubscriptionItem implements CustomListItem {

    String imageUrl;
    String info;
    String firstMonth;
    String secondMonthOnwards;

    public MindMonthlySubscriptionItem(String imageUrl, String info, String firstMonth, String secondMonthOnwards) {
        this.imageUrl = imageUrl;
        this.info = info;
        this.firstMonth = firstMonth;
        this.secondMonthOnwards = secondMonthOnwards;
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

    @Override
    public int getType() {
        return CustomListItem.TYPE_MONTHLYSUB;
    }
}
