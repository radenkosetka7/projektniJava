package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static final int brojFigura = 4;
    public static int id = 1;
    private final String ime;
    private boolean zavrsioKretanje = false;
    private Random rand = new Random();
    private ColorOfFIgure bojaIgraca;

    public ArrayList<Figure> getFigureIgraca() {
        return figureIgraca;
    }

    private final ArrayList<Figure> figureIgraca = new ArrayList<>(brojFigura);

    public Player(ColorOfFIgure boja) {
        this.ime="Igrač " + id;
        this.bojaIgraca =boja;
        id++;
        dodajFigure(this.bojaIgraca);
    }

    public boolean isZavrsioKretanje() {
        return zavrsioKretanje;
    }


    public String getIme() {
        return ime;
    }

    public void setZavrsioKretanje(boolean zavrsioKretanje) {
        this.zavrsioKretanje = zavrsioKretanje;
    }

    public Player(String ime, ColorOfFIgure boja) {
        this.ime = ime;
        dodajFigure(boja);
    }

    private void dodajFigure(ColorOfFIgure boja) {

        for (int i = 0; i < brojFigura; i++) {
            int tip = rand.nextInt(3);
            Figure figure = null;
            switch (tip) {
                case 0:
                    figure = new SimpleFigure(boja);
                    break;
                case 1:
                    figure = new HoverFigure(boja);
                    break;
                case 2:
                    figure = new SuperFastFigure(boja);
                    break;
            }
            figureIgraca.add(figure);
        }
    }

    public void igracNaPotezu(int pomjeraj) {
        Figure slobodnaFigura = null;
        for (Figure f : figureIgraca) {
            if (!f.isZavrsila()) {
                slobodnaFigura = f;
            }
        }

        //izabrana figura sa kojom ce igrati
        if (slobodnaFigura == null) {
            this.setZavrsioKretanje(true);
        } else {
            //da li mi treba trenutna fig uopste ili mogu raditi sa ovom slobodnaFigura? xd
            slobodnaFigura.kreni(this, pomjeraj);
        }

    }

    public ColorOfFIgure getBojaIgraca() {
        return bojaIgraca;
    }

    public void setBojaIgraca(ColorOfFIgure bojaIgraca) {
        this.bojaIgraca = bojaIgraca;
    }
}
