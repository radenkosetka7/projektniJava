package com.example.projektnijava.contollers;

import com.example.projektnijava.game.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        procitajSetup();
    }

    public void procitajSetup() {
        try {
            List<String> content = new ArrayList<>();
            content = Files.readAllLines(Path.of("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "setup.txt"));
            if (content.size() != 2) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Neispavan unos!");
                alert.showAndWait().ifPresent(a -> {
                    if (a == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
                System.exit(0);
            } else {
                for (String line : content) {
                    String[] parts = line.split(" ");
                    if (parts[0].contains("Igraci")) {
                        Main.brojIgraca = Integer.parseInt(parts[1]);
                    } else if (parts[0].contains("Dimenzija")) {
                        Main.dimenzijaMatrice = Integer.parseInt(parts[1]);
                    }
                }
            }

            if ((Main.dimenzijaMatrice < 7 || Main.dimenzijaMatrice > 10) || (Main.brojIgraca < 2 || Main.brojIgraca > 4)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Neispavan unos!");
                alert.showAndWait().ifPresent(a -> {
                    if (a == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
