package com.example.projektnijava.game;

public class SuperFastFigure extends Figure implements SuperFastInterface{

    private ColorOfFIgure boja;

    public SuperFastFigure() {

    }

    @Override
    public void kreni(Player player, int brojKoraka) {

    }

    public SuperFastFigure(ColorOfFIgure boja) {
        this.boja = boja;
    }
}
