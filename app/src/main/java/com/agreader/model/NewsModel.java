package com.agreader.model;

public class NewsModel {
    String id, image, title, price, time, description, termCondition, agClientBrand_id, type, url, brand, client, artikel;

    public NewsModel() {
    }

    public String getArtikel() {
        return artikel;
    }

    public void setArtikel(String artikel) {
        this.artikel = artikel;
    }

    public NewsModel(String id, String image, String title, String artikel, String time, String url, String type) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.artikel = artikel;
        this.time = time;
        this.url = url;
        this.type = type;
    }

    public NewsModel(String id, String image, String title, String price, String time, String description, String termCondition, String agClientBrand_id, String type, String url) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.time = time;
        this.description = description;
        this.termCondition = termCondition;
        this.agClientBrand_id = agClientBrand_id;
        this.type = type;
        this.url = url;

    }

    public NewsModel(String id, String image, String title, String price, String time, String description, String termCondition, String agClientBrand_id, String type, String url, String brand, String client) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.time = time;
        this.description = description;
        this.termCondition = termCondition;
        this.agClientBrand_id = agClientBrand_id;
        this.type = type;
        this.url = url;
        this.brand = brand;
        this.client = client;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermCondition() {
        return termCondition;
    }

    public void setTermCondition(String termCondition) {
        this.termCondition = termCondition;
    }

    public String getAgClientBrand_id() {
        return agClientBrand_id;
    }

    public void setAgClientBrand_id(String agClientBrand_id) {
        this.agClientBrand_id = agClientBrand_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}