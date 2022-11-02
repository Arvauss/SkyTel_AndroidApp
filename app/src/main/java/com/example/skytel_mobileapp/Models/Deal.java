package com.example.skytel_mobileapp.Models;

public class Deal {

    private String dealTitle;
    private String dealDesc;
    private String dealImgURL;

    public Deal(){

    }

    public Deal(String title, String desc, String imgUrl){
        this.dealTitle = title;
        this.dealDesc = desc;
        this.dealImgURL = imgUrl;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(String dealTitle) {
        this.dealTitle = dealTitle;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public String getDealImgURL() {
        return dealImgURL;
    }

    public void setDealImgURL(String dealImgURL) {
        this.dealImgURL = dealImgURL;
    }
}
