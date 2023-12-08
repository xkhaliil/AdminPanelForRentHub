package com.example.adminrenthub;

public class Cars {
    String id;
    String name;
    String price;
    String availibility;
    String type;

    public Cars(String id, String name, String price, String availibility, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availibility = availibility;
        this.type = type;
    }
    public Cars(String type, String name, String price, String availibility) {
        this.name = name;
        this.price = price;
        this.availibility = availibility;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailibility() {
        return availibility;
    }

    public void setAvailibility(String availibility) {
        this.availibility = availibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
