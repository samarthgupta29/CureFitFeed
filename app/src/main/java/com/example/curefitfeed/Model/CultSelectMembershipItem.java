package com.example.curefitfeed.Model;

import java.util.ArrayList;
import java.util.List;

public class CultSelectMembershipItem implements CustomListItem {

    String headerInfo1;
    String headerInfo2;
    String headerInfo3;
    String headerInfo4;
    List<CultselectmembershipDetail> detailList;

    public CultSelectMembershipItem(String headerInfo1, String headerInfo2, String headerInfo3, String headerInfo4, List<CultselectmembershipDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.headerInfo2 = headerInfo2;
        this.headerInfo3 = headerInfo3;
        this.headerInfo4 = headerInfo4;
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

    public String getHeaderInfo4() {
        return headerInfo4;
    }

    public void setHeaderInfo4(String headerInfo4) {
        this.headerInfo4 = headerInfo4;
    }

    public List<CultselectmembershipDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(ArrayList<CultselectmembershipDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_UNLIMITEDMEMBERSHIP;
    }
}
