
package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CultVpImages {

    @SerializedName("cult_vp_images")
    @Expose
    private List<CultVpImage> cultVpImages = null;

    public List<CultVpImage> getCultVpImages() {
        return cultVpImages;
    }

    public void setCultVpImages(List<CultVpImage> cultVpImages) {
        this.cultVpImages = cultVpImages;
    }

}