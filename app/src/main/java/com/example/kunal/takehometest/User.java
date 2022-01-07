package com.example.kunal.takehometest;

public class User {

    private String name;
    private String user_name;
    private String full_name;
    private String phone_number;
    private String registration;
    private String image;

    public User(String name, String user_name, String full_name, String phone_number, String registration, String image) {
        this.name = name;
        this.user_name = user_name;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.registration = registration;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
