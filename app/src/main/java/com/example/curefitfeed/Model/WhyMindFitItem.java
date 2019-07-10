package com.example.curefitfeed.Model;

import java.util.ArrayList;
import java.util.List;

public class WhyMindFitItem implements CustomListItem {

    String headerInfo1;
    List<WhymindfitDetail> detailList;

    public WhyMindFitItem(String headerInfo1, List<WhymindfitDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.detailList = detailList;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public List<WhymindfitDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<WhymindfitDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_WHYMINDFIT;
    }
}
