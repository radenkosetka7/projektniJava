module com.example.projektnijava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projektnijava to javafx.fxml;
    exports com.example.projektnijava;
}