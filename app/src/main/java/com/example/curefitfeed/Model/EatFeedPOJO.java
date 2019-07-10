package com.example.curefitfeed.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EatFeedPOJO {

    @SerializedName("eatFeed")
    @Expose
    private List<EatFeed> eatFeed = null;

    public List<EatFeed> getEatFeed() {
        return eatFeed;
    }

    public void setEatFeed(List<EatFeed> eatFeed) {
        this.eatFeed = eatFeed;
    }

}
