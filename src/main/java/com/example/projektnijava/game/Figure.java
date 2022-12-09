package com.example.projektnijava.game;

public abstract class Figure {

    private Color boja;
    private String skracenica;
    private boolean zavrsila=false;


    public Figure() {
    }

    public Color getBoja() {
        return boja;
    }

    public void setBoja(Color boja) {
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
}
