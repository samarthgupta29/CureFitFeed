package com.example.curefitfeed.Model;

import java.util.List;

public class CultWorkoutItem implements CustomListItem {

    String headerInfo1;
    List<CultworkoutDetail> detailList;

    public CultWorkoutItem(String headerInfo1, List<CultworkoutDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.detailList = detailList;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public List<CultworkoutDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CultworkoutDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_GRID;
    }
}
