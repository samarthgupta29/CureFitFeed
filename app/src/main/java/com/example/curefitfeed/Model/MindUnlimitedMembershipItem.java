package com.example.curefitfeed.Model;

import java.util.ArrayList;
import java.util.List;

public class MindUnlimitedMembershipItem implements CustomListItem {

    String headerInfo_1;
    String headerInfo_2;
    List<UnlimitedmembershipDetail> detailList;

    public MindUnlimitedMembershipItem(String headerInfo_1, String headerInfo_2, List<UnlimitedmembershipDetail> detailList) {
        this.headerInfo_1 = headerInfo_1;
        this.headerInfo_2 = headerInfo_2;
        this.detailList = detailList;
    }

    public String getHeaderInfo_1() {
        return headerInfo_1;
    }

    public void setHeaderInfo_1(String headerInfo_1) {
        this.headerInfo_1 = headerInfo_1;
    }

    public String getHeaderInfo_2() {
        return headerInfo_2;
    }

    public void setHeaderInfo_2(String headerInfo_2) {
        this.headerInfo_2 = headerInfo_2;
    }

    public List<UnlimitedmembershipDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<UnlimitedmembershipDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_UNLIMITEDMEMBERSHIP;
    }
}
