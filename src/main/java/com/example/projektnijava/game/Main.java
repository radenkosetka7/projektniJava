package com.example.projektnijava.game;

import com.example.projektnijava.contollers.MainController;
import javafx.application.Platform;
import javafx.geometry.Pos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static com.example.projektnijava.contollers.MainController.mc;
import static com.example.projektnijava.game.MyLogger.logger;

public class Main {

    public static LinkedHashMap<Integer, Position> putanjaFigure = new LinkedHashMap<>();
    public static List<Card> karte = new ArrayList<>();
    public static List<Player> igraci = new ArrayList<>();
    public static List<Player> tempIgraci=new ArrayList<>();
    public static int dimenzijaMatrice;
    public static int brojIgraca;
    public static boolean pauziranaSimulacija = false;
    public static long vrijemeIgre;
    public static Matrix[][] matrica;
    //public static MainController mc = new MainController();
    public static Object pauza = new Object();
    public static Random rand = new Random();
    public static boolean simulacijaZavrsena=false;

    public Main() {
        setujPutanjuFigure();
        addCards();
        addPlayers();
        matrica=new Matrix[dimenzijaMatrice][dimenzijaMatrice];
        for(int i=0;i<dimenzijaMatrice;i++)
        {
            for(int j=0;j<dimenzijaMatrice;j++)
            {
                matrica[i][j]=new Matrix();
            }
        }

    }

    public void setujPutanjuFigure() {
        if (dimenzijaMatrice == 7) {
            putanjaFigure.put(4, new Position(0, 3));
            putanjaFigure.put(12, new Position(1, 4));
            putanjaFigure.put(20, new Position(2, 5));
            putanjaFigure.put(28, new Position(3, 6));
            putanjaFigure.put(34, new Position(4, 5));
            putanjaFigure.put(40, new Position(5, 4));
            putanjaFigure.put(46, new Position(6, 3));
            putanjaFigure.put(38, new Position(5, 2));
            putanjaFigure.put(30, new Position(4, 1));
            putanjaFigure.put(22, new Position(3, 0));
            putanjaFigure.put(16, new Position(2, 1));
            putanjaFigure.put(10, new Position(1, 2));
            putanjaFigure.put(11, new Position(1, 3));
            putanjaFigure.put(19, new Position(2, 4));
            putanjaFigure.put(27, new Position(3, 5));
            putanjaFigure.put(33, new Position(4, 4));
            putanjaFigure.put(39, new Position(5, 3));
            putanjaFigure.put(31, new Position(4, 2));
            putanjaFigure.put(23, new Position(3, 1));
            putanjaFigure.put(17, new Position(2, 2));
            putanjaFigure.put(18, new Position(2, 3));
            putanjaFigure.put(26, new Position(3, 4));
            putanjaFigure.put(32, new Position(4, 3));
            putanjaFigure.put(24, new Position(3, 2));
            putanjaFigure.put(25, new Position(3, 3));
        } else if (dimenzijaMatrice == 8) {
            putanjaFigure.put(5, new Position(0, 4));
            putanjaFigure.put(14, new Position(1, 5));
            putanjaFigure.put(23, new Position(2, 6));
            putanjaFigure.put(32, new Position(3, 7));
            putanjaFigure.put(39, new Position(4, 6));
            putanjaFigure.put(46, new Position(5, 5));
            putanjaFigure.put(53, new Position(6, 4));
            putanjaFigure.put(60, new Position(7, 3));
            putanjaFigure.put(51, new Position(6, 2));
            putanjaFigure.put(42, new Position(5, 1));
            putanjaFigure.put(33, new Position(4, 0));
            putanjaFigure.put(26, new Position(3, 1));
            putanjaFigure.put(19, new Position(2, 2));
            putanjaFigure.put(12, new Position(1, 3));
            putanjaFigure.put(13, new Position(1, 4));
            putanjaFigure.put(22, new Position(2, 5));
            putanjaFigure.put(31, new Position(3, 6));
            putanjaFigure.put(38, new Position(4, 5));
            putanjaFigure.put(45, new Position(5, 4));
            putanjaFigure.put(52, new Position(6, 3));
            putanjaFigure.put(43, new Position(5, 2));
            putanjaFigure.put(34, new Position(4, 1));
            putanjaFigure.put(27, new Position(3, 2));
            putanjaFigure.put(20, new Position(2, 3));
            putanjaFigure.put(21, new Position(2, 4));
            putanjaFigure.put(30, new Position(3, 5));
            putanjaFigure.put(37, new Position(4, 4));
            putanjaFigure.put(44, new Position(5, 3));
            putanjaFigure.put(35, new Position(4, 2));
            putanjaFigure.put(28, new Position(3, 3));
            putanjaFigure.put(29, new Position(3, 4));
            putanjaFigure.put(36, new Position(4, 3));

        } else if (dimenzijaMatrice == 9) {
            putanjaFigure.put(5, new Position(0, 4));
            putanjaFigure.put(15, new Position(1, 5));
            putanjaFigure.put(25, new Position(2, 6));
            putanjaFigure.put(35, new Position(3, 7));
            putanjaFigure.put(45, new Position(4, 8));
            putanjaFigure.put(53, new Position(5, 7));
            putanjaFigure.put(61, new Position(6, 6));
            putanjaFigure.put(69, new Position(7, 5));
            putanjaFigure.put(77, new Position(8, 4));
            putanjaFigure.put(67, new Position(7, 3));
            putanjaFigure.put(57, new Position(6, 2));
            putanjaFigure.put(47, new Position(5, 1));
            putanjaFigure.put(37, new Position(4, 0));
            putanjaFigure.put(29, new Position(3, 1));
            putanjaFigure.put(21, new Position(2, 2));
            putanjaFigure.put(13, new Position(1, 3));
            putanjaFigure.put(14, new Position(1, 4));
            putanjaFigure.put(24, new Position(2, 5));
            putanjaFigure.put(34, new Position(3, 6));
            putanjaFigure.put(44, new Position(4, 7));
            putanjaFigure.put(52, new Position(5, 6));
            putanjaFigure.put(60, new Position(6, 5));
            putanjaFigure.put(68, new Position(7, 4));
            putanjaFigure.put(58, new Position(6, 3));
            putanjaFigure.put(48, new Position(5, 2));
            putanjaFigure.put(38, new Position(4, 1));
            putanjaFigure.put(30, new Position(3, 2));
            putanjaFigure.put(22, new Position(2, 3));
            putanjaFigure.put(23, new Position(2, 4));
            putanjaFigure.put(33, new Position(3, 5));
            putanjaFigure.put(43, new Position(4, 6));
            putanjaFigure.put(51, new Position(5, 5));
            putanjaFigure.put(59, new Position(6, 4));
            putanjaFigure.put(49, new Position(5, 3));
            putanjaFigure.put(39, new Position(4, 2));
            putanjaFigure.put(31, new Position(3, 3));
            putanjaFigure.put(32, new Position(3, 4));
            putanjaFigure.put(42, new Position(4, 5));
            putanjaFigure.put(50, new Position(5, 4));
            putanjaFigure.put(40, new Position(4, 3));
            putanjaFigure.put(41, new Position(4, 4));
        } else if (dimenzijaMatrice == 10) {
            putanjaFigure.put(6, new Position(0, 5));
            putanjaFigure.put(17, new Position(1, 6));
            putanjaFigure.put(28, new Position(2, 7));
            putanjaFigure.put(39, new Position(3, 8));
            putanjaFigure.put(50, new Position(4, 9));
            putanjaFigure.put(59, new Position(5, 8));
            putanjaFigure.put(68, new Position(6, 7));
            putanjaFigure.put(77, new Position(7, 6));
            putanjaFigure.put(86, new Position(8, 5));
            putanjaFigure.put(95, new Position(9, 4));
            putanjaFigure.put(84, new Position(8, 3));
            putanjaFigure.put(73, new Position(7, 2));
            putanjaFigure.put(62, new Position(6, 1));
            putanjaFigure.put(51, new Position(5, 0));
            putanjaFigure.put(42, new Position(4, 1));
            putanjaFigure.put(33, new Position(3, 2));
            putanjaFigure.put(24, new Position(2, 3));
            putanjaFigure.put(15, new Position(1, 4));
            putanjaFigure.put(16, new Position(1, 5));
            putanjaFigure.put(27, new Position(2, 6));
            putanjaFigure.put(38, new Position(3, 7));
            putanjaFigure.put(49, new Position(4, 8));
            putanjaFigure.put(58, new Position(5, 7));
            putanjaFigure.put(67, new Position(6, 6));
            putanjaFigure.put(76, new Position(7, 5));
            putanjaFigure.put(85, new Position(8, 4));
            putanjaFigure.put(74, new Position(7, 3));
            putanjaFigure.put(63, new Position(6, 2));
            putanjaFigure.put(52, new Position(4, 1));
            putanjaFigure.put(43, new Position(4, 2));
            putanjaFigure.put(34, new Position(3, 3));
            putanjaFigure.put(25, new Position(2, 4));
            putanjaFigure.put(26, new Position(2, 5));
            putanjaFigure.put(37, new Position(3, 6));
            putanjaFigure.put(48, new Position(4, 7));
            putanjaFigure.put(57, new Position(5, 6));
            putanjaFigure.put(66, new Position(6, 5));
            putanjaFigure.put(75, new Position(7, 4));
            putanjaFigure.put(64, new Position(6, 3));
            putanjaFigure.put(53, new Position(5, 2));
            putanjaFigure.put(44, new Position(4, 3));
            putanjaFigure.put(35, new Position(3, 4));
            putanjaFigure.put(36, new Position(3, 5));
            putanjaFigure.put(47, new Position(4, 6));
            putanjaFigure.put(56, new Position(5, 5));
            putanjaFigure.put(65, new Position(6, 4));
            putanjaFigure.put(54, new Position(5, 3));
            putanjaFigure.put(45, new Position(4, 4));
            putanjaFigure.put(46, new Position(4, 5));
            putanjaFigure.put(55, new Position(5, 4));
        }

    }

    public void addPlayers() {
        List<ColorOfFIgure> colors = Arrays.asList(ColorOfFIgure.values());
        Collections.shuffle(colors);
        for (int i = 0; i < brojIgraca; i++) {
            Player player=new Player(colors.get(i));
            igraci.add(player);
            tempIgraci.add(player);
        }
    }


    public void addCards() {
        for (int i = 0; i < 10; i++) {

            karte.add(new OrdinaryCard("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "card1.png"));
            karte.add(new OrdinaryCard("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "card2.png"));
            karte.add(new OrdinaryCard("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "card3.png"));
            karte.add(new OrdinaryCard("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "card4.png"));
        }
        for (int i = 0; i < 12; i++) {
            karte.add(new SpecialCard("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "joker.png"));

        }
        Collections.shuffle(karte);
    }

    public void zapocniIgru() {
        GhostFigure figure = new GhostFigure();
        figure.start();

        while (tempIgraci.size() > 0)
      {
            Card tmpKarta = karte.remove(0);
            //pozovi fju za stavljanje slike
            mc.postaviKartu(tmpKarta);
            if (tmpKarta instanceof SpecialCard) {
                ((SpecialCard) tmpKarta).dodajRupu();

            } else if (tmpKarta instanceof OrdinaryCard) {
                Player tmpIgrac = tempIgraci.stream().findFirst().get();//uzme prvog igraca
                tempIgraci.remove(tmpIgrac);
                int brojPolja = ((OrdinaryCard) tmpKarta).getBrojPolja();
                tmpIgrac.igracNaPotezu(brojPolja);
                 if (!tmpIgrac.isZavrsioKretanje()) {
                    tempIgraci.add(tmpIgrac);
                }

            }
            karte.add(tmpKarta);

        }
        simulacijaZavrsena=true;
        saveResults();
    }

    public void saveResults()
    {
        try
        {
            String fileName = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" +
                    File.separator + "example" + File.separator + "projektnijava" + File.separator + "results" + File.separator +
                    String.format("IGRA_%d.txt", Calendar.getInstance().getTimeInMillis());
            FileWriter fileWriter=new FileWriter(fileName);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            String tekst="";
            for(Player p:igraci)
            {

                String parts[]=p.getIme().split(" ");
                int i=Integer.parseInt(parts[1]);
                String pom="Igrac" +i;
                tekst+=pom+" - " + p.getIme() + "\n";
                for(Figure f:p.getFigureIgraca()) {
                    tekst += f.getNaziv() + "(" + f.getSkracenica() + ", " + f.getBoja() + ") - predjeni put (";
                    String tmpPutanjaFigure = "";
                    for (Position position : f.getFiguraPresla()) {
                        int broj=mc.getKey(position);
                        tmpPutanjaFigure+=broj+"-";
                    }
                    String putanja=tmpPutanjaFigure.substring(0,tmpPutanjaFigure.length()-1);
                    String stigla=f.isUspjesnoZavrsila()?"da":"ne";
                    tekst+=putanja+") - stigla do cilja? " + stigla +"\n";

                }

                tekst+="\n";
            }
            tekst+="\n";

            tekst+="Ukupno vrijeme trajanja igre: " + vrijemeIgre + "[s]";

            bufferedWriter.write(tekst);
            bufferedWriter.flush();
            bufferedWriter.close();

        }
        catch(Exception e)
        {
            logger.severe(e.fillInStackTrace().toString());
        }
    }
}
