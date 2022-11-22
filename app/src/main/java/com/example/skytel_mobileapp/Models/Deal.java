package com.example.skytel_mobileapp.Models;

public class Deal {
    private String id;
    private String Title;
    private String Description;
/*    private String dealPermURL;
    private String dealAddURL;*/

    public Deal(){

    }

    public Deal(String dID, String title, String desc, String permUrl, String addUrl){
        this.id = dID;
        this.Title = title;
        this.Description = desc;
        /*this.dealPermURL = permUrl;
        this.dealAddURL = addUrl;*/
    }



/*    public String getDealPermURL() {
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
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
