package com.example.curefitfeed.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WhymindfitDetail {

    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("info")
    @Expose
    private String info;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
