// Elizabeth Dzifa
// 10907691
package com.example.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class InventoryManagementSystem extends Application {

    // Create the UI components
    private Button addGoodsButton;
    private Button viewVendorsButton;
    private Button viewGoodsButton;
    private Button viewBillsButton;
    private Button viewIssuedGoodsButton;

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Set up the main screen
        primaryStage.setTitle("Inventory Management System");

        addGoodsButton = new Button("Add Goods");
        viewVendorsButton = new Button("View Vendors");
        viewGoodsButton = new Button("View Goods");
        viewBillsButton = new Button("View Bills");
        viewIssuedGoodsButton = new Button("View Issued Goods");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(addGoodsButton, viewVendorsButton, viewGoodsButton, viewBillsButton, viewIssuedGoodsButton);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set up event handlers
        addGoodsButton.setOnAction(e -> openAddGoodsScreen());
        viewVendorsButton.setOnAction(e -> openViewVendorsScreen());
        viewGoodsButton.setOnAction(e -> openViewGoodsScreen());
        viewBillsButton.setOnAction(e -> openViewBillsScreen());
        viewIssuedGoodsButton.setOnAction(e -> openViewIssuedGoodsScreen());
    }

    private void openAddGoodsScreen() {
        Stage addGoodsStage = new Stage();
        addGoodsStage.setTitle("Add Goods");

        // Create UI components for the Add Goods screen
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();

        Label categoryLabel = new Label("Category:");
        TextField categoryTextField = new TextField();

        Label quantityLabel = new Label("Quantity:");
        TextField quantityTextField = new TextField();

        Label priceLabel = new Label("Price:");
        TextField priceTextField = new TextField();

        Button saveButton = new Button("Save");

        // Set up layout for the Add Goods screen
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(nameLabel, nameTextField, categoryLabel, categoryTextField,
                quantityLabel, quantityTextField, priceLabel, priceTextField, saveButton);

        Scene scene = new Scene(vbox, 400, 300);
        addGoodsStage.setScene(scene);
        addGoodsStage.show();

        // Logic for saving the goods data
        saveButton.setOnAction(e -> {
            String name = nameTextField.getText();
            String category = categoryTextField.getText();
            int quantity = Integer.parseInt(quantityTextField.getText());
            double price = Double.parseDouble(priceTextField.getText());

            // Save the goods data to the database or perform any other necessary actions

            // Close the Add Goods screen
            addGoodsStage.close();
        });
    }

    private void openViewVendorsScreen() {
        Stage viewVendorsStage = new Stage();
        viewVendorsStage.setTitle("View Vendors");

        // Retrieve vendor data from the database
        // Assuming you have a DatabaseManager class for handling database operations
        DatabaseManager databaseManager = new DatabaseManager();
        // Assuming you have a method called getVendors() that returns a list of Vendor objects
        List<Vendor> vendors = databaseManager.getVendors();

        // Create a TableView to display the vendor data
        TableView<Vendor> tableView = new TableView<>();

        TableColumn<Vendor, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Vendor, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Vendor, String> contactColumn = new TableColumn<>("Contact");
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<Vendor, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableView.getColumns().addAll(idColumn, nameColumn, contactColumn, addressColumn);

        // Add vendor data to the TableView
        tableView.getItems().addAll(vendors);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(tableView);

        Scene scene = new Scene(vbox, 600, 400);
        viewVendorsStage.setScene(scene);
        viewVendorsStage.show();
    }

    private void openViewGoodsScreen() {
        Stage viewGoodsStage = new Stage();
        viewGoodsStage.setTitle("View Goods");

        // Retrieve goods data from the database
        DatabaseManager databaseManager = new DatabaseManager();
        List<Good> goods = databaseManager.getGoods();

        // Create a TableView to display the goods data
        TableView<Good> tableView = new TableView<>();

        TableColumn<Good, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Good, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Good, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Good, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Good, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.getColumns().addAll(idColumn, nameColumn, categoryColumn, quantityColumn, priceColumn);

        // Add goods data to the TableView
        tableView.getItems().addAll(goods);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(tableView);

        Scene scene = new Scene(vbox, 600, 400);
        viewGoodsStage.setScene(scene);
        viewGoodsStage.show();
    }

    private void openViewBillsScreen() {
        Stage viewBillsStage = new Stage();
        viewBillsStage.setTitle("View Bills");

        // Retrieve bill data from the database
        DatabaseManager databaseManager = new DatabaseManager();
        List<Bill> bills = databaseManager.getBills();

        // Create a TableView to display the bill data
        TableView<Bill> tableView = new TableView<>();

        TableColumn<Bill, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Bill, Integer> vendorIdColumn = new TableColumn<>("Vendor ID");
        vendorIdColumn.setCellValueFactory(new PropertyValueFactory<>("vendorId"));

        TableColumn<Bill, Integer> goodsIdColumn = new TableColumn<>("Goods ID");
        goodsIdColumn.setCellValueFactory(new PropertyValueFactory<>("goodsId"));

        TableColumn<Bill, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Bill, Double> totalPriceColumn = new TableColumn<>("Total Price");
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        TableColumn<Bill, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.getColumns().addAll(idColumn, vendorIdColumn, goodsIdColumn, quantityColumn, totalPriceColumn, dateColumn);

        // Add bill data to the TableView
        tableView.getItems().addAll(bills);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(tableView);

        Scene scene = new Scene(vbox, 600, 400);
        viewBillsStage.setScene(scene);
        viewBillsStage.show();
    }

    private void openViewIssuedGoodsScreen() {
        Stage viewIssuedGoodsStage = new Stage();
        viewIssuedGoodsStage.setTitle("View Issued Goods");

        // Retrieve issued goods data from the database
        DatabaseManager databaseManager = new DatabaseManager();
        List<IssuedGood> issuedGoods = databaseManager.getIssuedGoods();

        // Create a TableView to display the issued goods data
        TableView<IssuedGood> tableView = new TableView<>();

        TableColumn<IssuedGood, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<IssuedGood, Integer> goodsIdColumn = new TableColumn<>("Goods ID");
        goodsIdColumn.setCellValueFactory(new PropertyValueFactory<>("goodsId"));

        TableColumn<IssuedGood, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<IssuedGood, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.getColumns().addAll(idColumn, goodsIdColumn, quantityColumn, dateColumn);

        // Add issued goods data to the TableView
        tableView.getItems().addAll(issuedGoods);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(tableView);

        Scene scene = new Scene(vbox, 600, 400);
        viewIssuedGoodsStage.setScene(scene);
        viewIssuedGoodsStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
