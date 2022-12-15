package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {

    private ColorOfFIgure boja;
    private String skracenica;
    private boolean zavrsila=false;
    public Position trenutnaPozicija;
    public Position pocetnaPozicija;
    public Position krajnjaPozicija;
    List<Position> figuraPresla = new ArrayList<>();
    //doradi ovo klasu


    public Figure() {
        trenutnaPozicija = Main.putanjaFigure.get(0);//jel ovo ok??
        pocetnaPozicija = trenutnaPozicija;
        int size=Main.putanjaFigure.size();
        krajnjaPozicija=Main.putanjaFigure.get(size);//ili size=1???
    }




    public ColorOfFIgure getBoja() {
        return boja;
    }

    public void setBoja(ColorOfFIgure boja) {
        this.boja = boja;
    }

    public String getSkracenica() {
        return skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }

    public boolean isZavrsila() {
        return zavrsila;
    }

    public void setZavrsila(boolean zavrsila) {
        this.zavrsila = zavrsila;
    }


    public abstract void kreni(Player player, int brojKoraka);
}
