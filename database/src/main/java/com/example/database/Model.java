package com.example.database;

import  javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "productos")
public class Model {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }


   public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Double getprice() {
        return price;
    }

    public void setprice(Double price) {
        this.price = price;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }

    
    @Id
    private Long id;
    private String name;
    private String description;
    private double price;
    private String image;

}
