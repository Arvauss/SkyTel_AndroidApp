package com.example.skytel_mobileapp.Models;

public class ContactUsModel {
    private String Location;
    private String Number;
    private String shop;

    public ContactUsModel(){};

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
