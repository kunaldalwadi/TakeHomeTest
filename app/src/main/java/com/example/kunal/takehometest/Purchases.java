package com.example.kunal.takehometest;

public class Purchases {

    private String image;
    private String purchase_date;
    private String item_name;
    private String price;
    private String serial;
    private String description;

    public Purchases(String image, String purchase_date, String item_name, String price, String serial, String description) {
        this.image = image;
        this.purchase_date = purchase_date;
        this.item_name = item_name;
        this.price = price;
        this.serial = serial;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
