package com.example.curefitfeed.Model;

import java.util.List;

public class TrainerItem implements CustomListItem {

    String headerInfo1;
    List<TrainerDetail> detailList;

    public TrainerItem(String headerInfo1, List<TrainerDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.detailList = detailList;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public List<TrainerDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TrainerDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_TRAINERS;
    }
}
