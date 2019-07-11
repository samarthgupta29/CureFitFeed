package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class EatVpImages {

    @SerializedName("eat_vp_images")
    @Expose
    private List<EatVpImage> eatVpImages = null;

    public List<EatVpImage> getEatVpImages() {
        return eatVpImages;
    }

    public void setEatVpImages(List<EatVpImage> eatVpImages) {
        this.eatVpImages = eatVpImages;
    }

}