package com.company.Item;

import java.util.*;

public class User {
    private String id;
    private  String firstName;
    private  String lastName;
    private int money;

    private Map<Product,Integer> userProductList;//list of buying products

    public Map<Product, Integer> getUserProductList() {
        return userProductList;
    }

    public void setUserProductList(Map<Product,Integer> userProductList) {
        this.userProductList = userProductList;
    }

    public User(String firstName, String lastName, int money) {
        this.userProductList = new HashMap<>();
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }



}
