package com.example.curefitfeed.Model;

import java.util.ArrayList;
import java.util.List;

public class WhyCultFitItem implements CustomListItem {

    String headerInfo1;
    List<WhycultfitDetail> detailList;

    public WhyCultFitItem(String headerInfo1, List<WhycultfitDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.detailList = detailList;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public List<WhycultfitDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<WhycultfitDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_WHYMINDFIT;
    }
}
