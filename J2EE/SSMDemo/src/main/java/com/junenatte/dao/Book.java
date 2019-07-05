package com.junenatte.dao;

import java.util.Date;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private String publisher;

    private Date publishdate;

    private Float price;

    private Integer categoryid;

    public Book(Integer id, String name, String author, String publisher, Date publishdate, Float price, Integer categoryid) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishdate = publishdate;
        this.price = price;
        this.categoryid = categoryid;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
}