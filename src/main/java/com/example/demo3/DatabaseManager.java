package com.example.demo3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    // Connection details for the MySQL database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/inventorydb";
    private static final String USERNAME = "username_here";
    private static final String PASSWORD = "password_here";

    // Retrieve a list of vendors from the database
    public List<Vendor> getVendors() {
        List<Vendor> vendors = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Vendors")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String contact = resultSet.getString("Contact");
                String address = resultSet.getString("Address");

                Vendor vendor = new Vendor(id, name, contact, address);
                vendors.add(vendor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendors;
    }

    // Retrieve a list of goods from the database
    public List<Good> getGoods() {
        List<Good> goods = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Goods")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String category = resultSet.getString("Category");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("Price");

                Good good = new Good(id, name, category, quantity, price);
                goods.add(good);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }

    // Retrieve a list of bills from the database
    public List<Bill> getBills() {
        List<Bill> bills = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Bills")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int vendorId = resultSet.getInt("VendorID");
                int goodsId = resultSet.getInt("GoodsID");
                int quantity = resultSet.getInt("Quantity");
                double totalPrice = resultSet.getDouble("TotalPrice");
                Date date = resultSet.getDate("Date");

                Bill bill = new Bill(id, vendorId, goodsId, quantity, totalPrice, date);
                bills.add(bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }

    // Retrieve a list of issued goods from the database
    public List<IssuedGood> getIssuedGoods() {
        List<IssuedGood> issuedGoods = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM IssuedGoods")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int goodsId = resultSet.getInt("GoodsID");
                int quantity = resultSet.getInt("Quantity");
                Date date = resultSet.getDate("Date");

                IssuedGood issuedGood = new IssuedGood(id, goodsId, quantity, date);
                issuedGoods.add(issuedGood);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issuedGoods;
    }

}
