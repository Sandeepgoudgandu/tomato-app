package com.foodapp.model;

public class FoodItem {
    private String name;
    private int price;
    public FoodItem(String name, int price) {
        this.name=name; this.price=price;
    }
    public String getName(){ return name; }
    public int getPrice(){ return price; }
}
