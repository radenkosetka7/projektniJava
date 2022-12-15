package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static final int brojFigura = 4;
    private Figure trenutnaFigura;
    public static int id = 1;
    private final String ime;
    private boolean zavrsioKretanje=false;
    private Random rand = new Random();

    private final ArrayList<Figure> figureIgraca = new ArrayList<>(brojFigura);

    public Player(ColorOfFIgure boja) {
        this("Igrač " + (id), boja);
        id++;
    }

    public boolean isZavrsioKretanje() {
        return zavrsioKretanje;
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

    public void igracNaPotezu(int pomjeraj)
    {
        Figure slobodnaFigura=null;
        for(Figure f:figureIgraca)
        {
            if(!f.isZavrsila())
            {
                slobodnaFigura=f;
            }
        }

        //izabrana figura sa kojom ce igrati
        if(slobodnaFigura == null)
        {
            this.setZavrsioKretanje(true);
        }
        else {
            //da li mi treba trenutna fig uopste ili mogu raditi sa ovom slobodnaFigura? xd
            trenutnaFigura=slobodnaFigura;
            trenutnaFigura.kreni(this,pomjeraj);
        }

    }
}
