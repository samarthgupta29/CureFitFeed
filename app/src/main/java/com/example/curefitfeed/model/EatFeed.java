package com.example.curefitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EatFeed {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("food")
    @Expose
    private Food food;
    @SerializedName("navItem")
    @Expose
    private NavItem navItem;
    @SerializedName("parent_id")
    @Expose
    private String parentId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public NavItem getNavItem() {
        return navItem;
    }

    public void setNavItem(NavItem navItem) {
        this.navItem = navItem;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}
