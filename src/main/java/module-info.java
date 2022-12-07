module ProjektniJava {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.logging;

    exports com.example.projektnijava;
    exports com.example.projektnijava.contollers;
    opens com.example.projektnijava to javafx.fxml;
    opens com.example.projektnijava.contollers to javafx.fxml;

}