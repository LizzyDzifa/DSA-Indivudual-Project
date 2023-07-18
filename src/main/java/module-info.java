module com.example.barasu691 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.barasu691 to javafx.fxml;
    exports com.example.barasu691;
}