package com.example.skytel_mobileapp.Models;

public class ContactUsModel {
    private String Title;
    private String ContactNum;

    public ContactUsModel(){};

    public ContactUsModel(String title, String contactNum) {
        Title = title;
        ContactNum = contactNum;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContactNum() {
        return ContactNum;
    }

    public void setContactNum(String contactNum) {
        ContactNum = contactNum;
    }
}
