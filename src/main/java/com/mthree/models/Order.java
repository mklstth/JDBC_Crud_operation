package com.mthree.models;

public class Order {
    private int o_id;
    private int s_id;
    private int siez;
    private int price;

    public Order(int o_id, int s_id, int siez, int price) {
        this.o_id = o_id;
        this.s_id = s_id;
        this.siez = siez;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "o_id=" + o_id +
                ", s_id=" + s_id +
                ", siez=" + siez +
                ", price=" + price +
                '}';
    }
}
