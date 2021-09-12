package com.example.gearapp;

import java.util.ArrayList;

public class GearInfo implements GearList{
    public String date, maker, descr, comment;
    public float price;

    public GearInfo(String date, String maker, String descr, String price, String comment){
        this.date = date;
        this.maker = maker;
        this.descr = descr;
        this.comment = comment;
        this.price = Float.parseFloat(price);  //change float to string
    }

    //Setter and Getter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //Minimally, each item in the list should show its date, description, and price.
    public String getData(){
        return "date: " + this.date + " /description: " + this.descr + " /price: " + this.price;
    }

}
