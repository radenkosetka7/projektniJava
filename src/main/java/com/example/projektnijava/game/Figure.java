package com.example.projektnijava.game;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Figure {

    private ColorOfFIgure boja;
    private String naziv;
    private String skracenica;
    private boolean zavrsila=false;
    public int dodatniKoraci = 0;
    public Position trenutnaPozicija;
    public Position pocetnaPozicija;
    public Position krajnjaPozicija;
    List<Position> figuraPresla = new ArrayList<>();
    public long vrijemeKretanja;
    public long starTimer;
    public  List<Position> valueList = new ArrayList<Position>(Main.putanjaFigure.values());
    public static int id = 1;
    //doradi ovo klasu


    public Figure(ColorOfFIgure boja,String skracenica) {
        this.skracenica=skracenica;
        this.boja=boja;
        this.naziv="Figura"+id;
        id++;
        List<Position> pozicije=new ArrayList<Position>(Main.putanjaFigure.values());
        trenutnaPozicija = pozicije.get(0);//jel ovo ok??
        pocetnaPozicija = trenutnaPozicija;
        int size=Main.putanjaFigure.size();
        krajnjaPozicija=pozicije.get(size-1);//ili size=1???
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getDodatniKoraci() {
        return dodatniKoraci;
    }

    public void setDodatniKoraci(int dodatniKoraci) {
        this.dodatniKoraci = dodatniKoraci;
    }

    public List<Position> getFiguraPresla() {
        return figuraPresla;
    }

    public void setFiguraPresla(List<Position> figuraPresla) {
        this.figuraPresla = figuraPresla;
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
