package com.example.projektnijava.game;

public class Matrix {

    private Hole hole;
    private Diamond diamond;
    private Figure figure;

    public Matrix()
    {
        this.hole=null;
        this.diamond=null;
        this.figure=null;
    }

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public Diamond getDiamond() {
        return diamond;
    }

    public void setDiamond(Diamond diamond) {
        this.diamond = diamond;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
