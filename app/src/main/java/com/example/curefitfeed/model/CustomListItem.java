package com.example.curefitfeed.model;

public interface CustomListItem {

    public int getType();

    public static int TYPE_FILTER = 0;
    public static int TYPE_FOOD = 1;
    public static int TYPE_HORIZONTAL_FEED = 2;
    public static int TYPE_HEADER = 3;
    public static int TYPE_GRID_FEED = 4;
    public static int TYPE_WHYMINDFIT = 5;
    public static int TYPE_UNLIMITEDMEMBERSHIP = 6;
    public static int TYPE_MONTHLYSUB = 7;
    public static int TYPE_GRID = 8;
    public static int TYPE_SELECTMEMBERSHIP = 9;
    public static int TYPE_TRAINERS = 10;

}
