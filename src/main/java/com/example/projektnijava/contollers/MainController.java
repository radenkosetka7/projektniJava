package com.example.projektnijava.contollers;

import com.example.projektnijava.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Label numberOfRoundsPlayed=new Label();
    public Label numbersPlayedLabel=new Label();
    public BorderPane borderPane=new BorderPane();
    public Button startButton=new Button();
    public HBox playersHBox=new HBox();
    public ListView figuresListView=new ListView();
    public HBox centerHBox=new HBox();
    public TextArea cardTextArea=new TextArea();
    public ImageView cardImageView=new ImageView();
    public Label timeLabel=new Label();
    private StackPane[][] matrica;

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

            matrica=new StackPane[Main.dimenzijaMatrice][Main.dimenzijaMatrice];
            GridPane gridPane=createGridPane(Main.dimenzijaMatrice,matrica);
            centerHBox.getChildren().add(1, gridPane);
            cardImageView.setStyle("-fx-background-color: WHITE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane createGridPane(int dimenzijaMatrice, StackPane[][] matrica) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        for (int i = 0; i < Main.dimenzijaMatrice; i++) {
            for (int j = 0; j < Main.dimenzijaMatrice; j++) {
                int number = i * Main.dimenzijaMatrice + j + 1;
                StackPane field = new StackPane();
                field.setStyle("-fx-background-color: WHITE");
                field.setAlignment(Pos.CENTER);
                field.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0.2))));
                Label labelDown = new Label(Integer.toString(number));
                labelDown.setAlignment(Pos.CENTER);
                labelDown.setPrefHeight(50);
                labelDown.setPrefWidth(50);
                field.getChildren().addAll(labelDown);
                gridPane.add(field, j, i);
                matrica[i][j] = field;
            }
        }
        return gridPane;
    }

    public void pokreniSimulaciju(ActionEvent actionEvent) {
    }

    public void prikaziKretanjeFigure(MouseEvent mouseEvent) {
    }

    public void prikaziRezultate(ActionEvent actionEvent) {
    }
}
