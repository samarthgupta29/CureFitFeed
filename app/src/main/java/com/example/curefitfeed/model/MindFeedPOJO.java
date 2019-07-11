
package com.example.curefitfeed.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MindFeedPOJO {



    @SerializedName("mindFeed")
    @Expose
    private List<MindFeed> mindFeed = null;

    public List<MindFeed> getMindFeed() {
        return mindFeed;
    }

    public void setMindFeed(List<MindFeed> mindFeed) {
        this.mindFeed = mindFeed;
    }

}


