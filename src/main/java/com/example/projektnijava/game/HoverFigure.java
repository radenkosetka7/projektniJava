package com.example.projektnijava.game;

public class HoverFigure extends Figure {
    private ColorOfFIgure boja;

    public HoverFigure() {

    }

    @Override
    public void kreni(Player player, int brojKoraka) {

    }

    public HoverFigure(ColorOfFIgure boja) {
        this.boja = boja;
    }
}
