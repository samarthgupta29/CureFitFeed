package com.example.curefitfeed.model;

import java.util.List;

public class CultUnlimitedMembershipItem implements CustomListItem {

    String headerInfo1;
    String headerInfo2;
    String headerInfo3;
    List<CultunlimitedmembershipDetail> detailList;

    public CultUnlimitedMembershipItem(String headerInfo1, String headerInfo2, String headerInfo3, List<CultunlimitedmembershipDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.headerInfo2 = headerInfo2;
        this.headerInfo3 = headerInfo3;
        this.detailList = detailList;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public String getHeaderInfo2() {
        return headerInfo2;
    }

    public void setHeaderInfo2(String headerInfo2) {
        this.headerInfo2 = headerInfo2;
    }

    public String getHeaderInfo3() {
        return headerInfo3;
    }

    public void setHeaderInfo3(String headerInfo3) {
        this.headerInfo3 = headerInfo3;
    }

    public List<CultunlimitedmembershipDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CultunlimitedmembershipDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_UNLIMITEDMEMBERSHIP;
    }
}
