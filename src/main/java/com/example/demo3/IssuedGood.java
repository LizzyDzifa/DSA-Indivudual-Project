package com.example.demo3;

import java.sql.Date;

public class IssuedGood {
    private int id;
    private int goodsId;
    private int quantity;
    private String date;

    public IssuedGood(int id, int goodsId, int quantity, String date) {
        this.id = id;
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.date = date;
    }

    public IssuedGood(int id, int goodsId, int quantity, Date date) {
    }

    public int getId() {
        return id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }
}

