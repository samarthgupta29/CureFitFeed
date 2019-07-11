
package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MindVpImages {

    @SerializedName("mind_vp_images")
    @Expose
    private List<MindVpImage> mindVpImages = null;

    public List<MindVpImage> getMindVpImages() {
        return mindVpImages;
    }

    public void setMindVpImages(List<MindVpImage> mindVpImages) {
        this.mindVpImages = mindVpImages;
    }

}