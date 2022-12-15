package com.example.projektnijava.contollers;

import com.example.projektnijava.game.Figure;
import com.example.projektnijava.game.Main;
import com.example.projektnijava.game.Position;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class FigureMovementController implements Initializable {
    public GridPane figurePane=new GridPane();
    public static FigureMovementController figura;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        for (int i = 0; i < Main.dimenzijaMatrice; i++) {
            ColumnConstraints col = new ColumnConstraints();
            //col.setMinWidth(col1);
            //col.setPrefWidth(col1);
            figurePane.getColumnConstraints().add(col);
        }
        for (int i = 0; i < Main.dimenzijaMatrice; i++) {
            RowConstraints row = new RowConstraints();
            //row.setMinHeight(row1);
           // row.setPrefHeight(row1);
            figurePane.getRowConstraints().add(row);
        }
        int content=1;
        for (int i = 0; i < Main.dimenzijaMatrice; i++) {
            for (int j = 0; j < Main.dimenzijaMatrice; j++) {
                Text text = new Text(" " + String.valueOf(content));
                text.setStyle("-fx-text-alignment: center");
                figurePane.add(text, j, i);
                content++;
            }
        }
        figura=this;


    }

    public void prikaziPredjeniPut(Figure figura)
    {
        for(Position p:figura.getFiguraPresla())
        {
            Rectangle rec=new Rectangle(10,10);
            rec.setFill(Color.PURPLE);
            Platform.runLater(()->
            {
                figurePane.add(rec,p.getY(),p.getX());
            });
        }
    }

}
