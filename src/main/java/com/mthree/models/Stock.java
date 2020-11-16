package com.mthree.models;

public class Stock {

    private String name;
    private int id;

    public Stock(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
