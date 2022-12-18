package com.example.projektnijava.contollers;

import com.example.projektnijava.game.MyLogger;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.example.projektnijava.game.MyLogger.logger;

public class ResultsController implements Initializable {
    public TextArea content=new TextArea();
    public ListView<String> fileList=new ListView<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        File[] files = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "results").listFiles();
        fileList.getItems().addAll(Arrays.stream(files).map(File::getName).collect(Collectors.toList()));
    }

    public void showFileContent(MouseEvent mouseEvent) {
        StringBuilder resultStringBuilder = new StringBuilder();
        String name=fileList.getSelectionModel().getSelectedItem();
        File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "results"+File.separator + name);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
            content.setText(resultStringBuilder.toString());
        } catch (IOException e) {
            logger.severe(e.fillInStackTrace().toString());

        }

    }
}
