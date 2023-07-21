package com.example.demo3;


import java.util.Date;

public class Bill {
    private int id;
    private int vendorId;
    private int goodsId;
    private int quantity;
    private double totalPrice;
    private String date;

    public Bill(int id, int vendorId, int goodsId, int quantity, double totalPrice, String date) {
        this.id = id;
        this.vendorId = vendorId;
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public Bill(int id, int vendorId, int goodsId, int quantity, double totalPrice, Date date) {
    }

    public int getId() {
        return id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDate() {
        return date;
    }
}

