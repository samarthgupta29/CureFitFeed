package com.example.curefitfeed.model;

public class HeaderItem implements CustomListItem {

    private NavItem navItem;

    public HeaderItem(NavItem navItem) {
        this.navItem = navItem;
    }

    public NavItem getNavItem() {
        return navItem;
    }

    public void setNavItem(NavItem navItem) {
        this.navItem = navItem;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_HEADER;
    }
}
