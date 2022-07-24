package com.company.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private int price;

    private List<User> thisProductBuyers = new ArrayList<>();//list with info about users who buy this product

    public List<User> getThisProductBuyers() {
        return thisProductBuyers;
    }

    public void setThisProductBuyers(List<User> thisProductBuyers) {
        this.thisProductBuyers = thisProductBuyers;
    }

    public Product(String name, int price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

