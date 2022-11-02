package com.example.skytel_mobileapp.Models;

public class Deal {
    private String dealID;
    private String dealTitle;
    private String dealDesc;
    private String dealPermURL;
    private String dealAddURL;

    public Deal(){

    }

    public Deal(String dID, String title, String desc, String permUrl, String addUrl){
        this.dealID = dID;
        this.dealTitle = title;
        this.dealDesc = desc;
        this.dealPermURL = permUrl;
        this.dealAddURL = addUrl;
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

    public String getDealPermURL() {
        return dealPermURL;
    }

    public void setDealPermURL(String dealPermURL) {
        this.dealPermURL = dealPermURL;
    }

    public String getDealAddURL() {
        return dealAddURL;
    }

    public void setDealAddURL(String dealAddURL) {
        this.dealAddURL = dealAddURL;
    }

    public String getDealID() {
        return dealID;
    }

    public void setDealID(String dealID) {
        this.dealID = dealID;
    }
}
