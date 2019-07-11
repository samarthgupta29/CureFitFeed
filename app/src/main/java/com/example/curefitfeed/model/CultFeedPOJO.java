
package com.example.curefitfeed.model;

import androidx.room.Entity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class CultFeedPOJO {

    @SerializedName("cultFeed")
    @Expose
    private List<CultFeed> cultFeed = null;

    public List<CultFeed> getCultFeed() {
        return cultFeed;
    }

    public void setCultFeed(List<CultFeed> cultFeed) {
        this.cultFeed = cultFeed;
    }

}


