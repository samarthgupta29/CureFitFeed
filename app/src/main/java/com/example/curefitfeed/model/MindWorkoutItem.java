package com.example.curefitfeed.model;

import java.util.List;

public class MindWorkoutItem implements CustomListItem {

    String headerInfo_1;
    List<WorkoutDetail> detailList;

    public MindWorkoutItem(String headerInfo_1, List<WorkoutDetail> detailList) {
        this.headerInfo_1 = headerInfo_1;
        this.detailList = detailList;
    }

    public String getHeaderInfo_1() {
        return headerInfo_1;
    }

    public void setHeaderInfo_1(String headerInfo_1) {
        this.headerInfo_1 = headerInfo_1;
    }

    public List<WorkoutDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<WorkoutDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_GRID;
    }
}
