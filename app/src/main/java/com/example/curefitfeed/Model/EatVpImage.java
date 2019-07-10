package com.example.curefitfeed.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EatVpImage {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
