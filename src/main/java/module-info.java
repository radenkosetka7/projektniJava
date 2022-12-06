module com.example.projektnijava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projektnijava to javafx.fxml;
    exports com.example.projektnijava;
    exports com.example.projektnijava.contollers;
    opens com.example.projektnijava.contollers to javafx.fxml;
    exports com.example.projektnijava.game;
    opens com.example.projektnijava.game to javafx.fxml;
}