package com.example.projektnijava.contollers;

import com.example.projektnijava.MainApplication;
import com.example.projektnijava.game.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.projektnijava.contollers.FigureMovementController.figura;
import static com.example.projektnijava.game.Main.igraci;
import static com.example.projektnijava.game.MyLogger.logger;
import static java.lang.Thread.sleep;

public class MainController implements Initializable {

    public final Image diamondSlika=new Image(new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator +
            "projektnijava" + File.separator + "pictures" + File.separator + "diamond.png").toURI().toString(),20,20,false,false);
    public Label numberOfRoundsPlayed=new Label();
    public Label numbersPlayedLabel=new Label();
    public BorderPane borderPane=new BorderPane();
    public Button startButton=new Button();
    public HBox playersHBox=new HBox();
    public ListView<String> figuresListView=new ListView();
    public HBox centerHBox=new HBox();
    public TextArea cardTextArea=new TextArea();
    public ImageView cardImageView=new ImageView();
    public Label timeLabel=new Label();
    private StackPane[][] matrica;
    public static boolean firstTime=true;
    public static int brojKlikova=0;
    public static Main main;
    public static MainController mc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        procitajSetup();
        main=new Main();
        mc=this;
        numbersPlayedLabel.setText(String.valueOf(tempBrojIgara()));
        List<Label> labele=new ArrayList<>();
        List<String> naziviFigura=new ArrayList<>();
        for(Player igrac: igraci)
        {
            Label label=new Label(igrac.getIme());
            if(igrac.getBojaIgraca().equals(ColorOfFIgure.ZUTA))
            {
                label.setTextFill(Color.YELLOW);
            }
            else if(igrac.getBojaIgraca().equals(ColorOfFIgure.CRVENA))
            {
                label.setTextFill(Color.RED);
            }
            else if(igrac.getBojaIgraca().equals(ColorOfFIgure.PLAVA))
            {
                label.setTextFill(Color.BLUE);
            }
            else {
                label.setTextFill(Color.GREEN);
            }
            labele.add(label);
            for(int i=0;i<igrac.getFigureIgraca().size();i++)
            {
                naziviFigura.add(igrac.getFigureIgraca().get(i).getNaziv());
            }
        }
        playersHBox.getChildren().addAll(labele);
        figuresListView.getItems().addAll(naziviFigura);
    }

    public void znacenjeKarte(Object... a) {
        String x = "";
        if (a.length == 1) //saljem broj rupa
        {
            x = "Specijalna karta, kreirano je " + a[0] +" rupa.";
        }
        else if(a.length==5)//ako je obicna ide igrac i pocetna i krajnja pozicija
        {
            String nazivIgraca = (String) a[0];
            String nazivFigure = (String) a[1];
            int pocetnaPozicija= (int) a[2];
            int krajnjaPozicija= (int) a[3];
            int prelazi=(int)a[4];
            x = "Na potezu je " + nazivIgraca + ", figura "+ nazivFigure+ ", prelazi "+ prelazi +  " polja, pomjera se sa pozicije " + pocetnaPozicija +" na poziciju " +krajnjaPozicija +".";
        }
        cardTextArea.setText(x);
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
            //Main.matrica=new Object[Main.dimenzijaMatrice][Main.dimenzijaMatrice];
        } catch (Exception e) {
            logger.severe(e.fillInStackTrace().toString());


        }
    }

    private Integer tempBrojIgara()
    {
        return tempMethodNumberOfGames();
    }

    private Integer tempMethodNumberOfGames()
    {
        File[] file=new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "results").listFiles();
        return file.length;
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

    public void postaviKartu(Card card)
    {
        Platform.runLater(()->
        {
            cardImageView.setImage(card.getSlika());
        });
    }

    public void postaviDiamond(int red,int kolona)
    {
        Platform.runLater(()->
        {
            ((Label)this.matrica[red][kolona].getChildren().get(0)).setGraphic(new ImageView(diamondSlika));
        });
    }
    public void skloniDiamond(int red,int kolona)
    {
        Platform.runLater(()->
        {
            ((Label)matrica[red][kolona].getChildren().get(0)).setGraphic(null);
        });
    }

    public void postaviFiguru(int red, int kolona, String skracenica,ColorOfFIgure boja)
    {
        String x="";
        if(boja.equals(ColorOfFIgure.PLAVA))
        {
            x="-fx-background-color: blue";
        }
        else if(boja.equals(ColorOfFIgure.CRVENA))
        {
            x="-fx-background-color: red";
        }
        else if(boja.equals(ColorOfFIgure.ZUTA))
        {
            x="-fx-background-color: yellow";
        }
        else if(boja.equals(ColorOfFIgure.ZELENA))
        {
            x="-fx-background-color: green";
        }

        String finalX = x;
        Platform.runLater(()->
        {
            Label labela=(Label) this.matrica[red][kolona].getChildren().get(0);
            labela.setText(skracenica);
            labela.setStyle(finalX);
        });
    }
    public int getKey(Position value) {
        for (Map.Entry<Integer, Position> entry : Main.putanjaFigure.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public void skloniFiguru(int red,int kolona,Integer broj)
    {
        Platform.runLater(()->
        {
            Label labela=(Label) this.matrica[red][kolona].getChildren().get(0);
            labela.setText(broj.toString());
            labela.setStyle("-fx-background-color: transparent");
        });
    }

    public void postaviRupu(int red,int kolona)
    {
        Platform.runLater(()->
        {
            Label labela = (Label) this.matrica[red][kolona].getChildren().get(0);
            labela.setStyle("-fx-background-color: black;");
        });
    }

    public void skloniRupu(int red,int kolona)
    {
        Platform.runLater(()->
        {
            Label labela = (Label) matrica[red][kolona].getChildren().get(0);
            labela.setStyle("-fx-background-color: transparent; -fx-border-color:transparent");
        });
    }

    private Thread trajanjeSimulacije()
    {
        return new Thread(()-> {

            int m=0,s=0;
            while(!Main.simulacijaZavrsena)
            {
                if(!Main.pauziranaSimulacija)
                {
                    Main.vrijemeIgre=s;
                    String formatiranoVrijeme=String.format("%d m %d s",m,s);
                    Platform.runLater(()->
                    {
                        timeLabel.setText(formatiranoVrijeme);
                    });
                    try
                    {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        logger.severe(e.fillInStackTrace().toString());


                    }
                    s++;
                    if(s>=60)
                    {
                        m++;
                        s%=60;
                    }

                }
                else
                {
                    System.out.print("");
                }
            }

        });
    }

    public void pokreniSimulaciju(ActionEvent actionEvent) {

        if (brojKlikova % 2 == 0) {
            zapocniIgru();

        } else {
            pauzirajIgru();
        }
        brojKlikova++;
    }

    public void zapocniIgru()
    {
        if(firstTime)
        {
            Thread simulacija=trajanjeSimulacije();
            simulacija.start();
            new Thread(()->main.zapocniIgru()).start();
            firstTime=false;
        }
        startButton.setText("Zaustavi");
        setPauzu(false);
    }

    public void pauzirajIgru()
    {
        startButton.setText("Pokreni");
        setPauzu(true);
    }

    public void setPauzu(boolean flag)
    {
        synchronized (Main.pauza)
        {
            if(!flag)
            {
                Main.pauza.notifyAll();
            }
        }
        Main.pauziranaSimulacija=flag;
    }
    public void prikaziKretanjeFigure(MouseEvent mouseEvent)
    {
        try {
            String selectedItem = figuresListView.getSelectionModel().getSelectedItem();
            Figure izabranaFigura=null;
            if(selectedItem==null)
            {
                return;
            }
            else
            {
                List<Figure> figures=new ArrayList<>();
                for(Player p:igraci)
                {
                    for(Figure f:p.getFigureIgraca())
                    {
                        figures.add(f);
                    }
                }
                for(Figure f:figures)
                {
                    if(f.getNaziv().equals(selectedItem))
                    {
                        izabranaFigura=f;
                        break;
                    }
                }
            }
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("figureMovement.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600, Color.GRAY);
            Stage newStage=new Stage();
            newStage.setTitle("Figura");
            newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.show();
            figura.prikaziPredjeniPut(izabranaFigura);
        }
        catch (Exception e)
        {
            logger.severe(e.fillInStackTrace().toString());
        }
    }

    public void prikaziRezultate(ActionEvent actionEvent) throws IOException {

        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("results.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600, Color.GRAY);
            Stage newStage=new Stage();
            newStage.setTitle("Results");
            newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.show();
        }
        catch (Exception e)
        {
            logger.severe(e.fillInStackTrace().toString());

        }
    }
}
