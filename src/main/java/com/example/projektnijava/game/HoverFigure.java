package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.projektnijava.game.Main.*;

public class HoverFigure extends Figure {

    public HoverFigure(ColorOfFIgure boja) {
        super(boja);
    }

    @Override
    public void kreni(Player igrac, int brojKoraka) {

        int i = 0;
        int brojDodatnihBodova = 0;
        brojKoraka += getDodatniKoraci();
        Position poljeSaKojegKrece = trenutnaPozicija;
        List<Position> valueList = new ArrayList<Position>(Main.putanjaFigure.values());
        Integer pozicija = valueList.indexOf(trenutnaPozicija);
        Position tmpPosition = valueList.get(pozicija + brojKoraka);
        if (matrica[tmpPosition.getX()][tmpPosition.getY()] instanceof Figure) {

            while (true) {
                brojKoraka++;
                Position tmpPosition2 = valueList.get(pozicija + brojKoraka);
                if (!(matrica[tmpPosition2.getX()][tmpPosition2.getY()] instanceof Figure)) {
                    break;
                }

            }
        }
        int tmp = valueList.indexOf(trenutnaPozicija);
        Position poljeNaKojeStaje = valueList.get(tmp + brojKoraka);
        int a=0;
        int b=0;
        for(Map.Entry<Integer,Position> p: putanjaFigure.entrySet())
        {
            if(p.getValue().equals(poljeSaKojegKrece))
            {
                a=p.getKey();
            }
            if(p.getValue().equals(poljeNaKojeStaje))
            {
                b=p.getKey();
            }
        }
        mc.znacenjeKarte(igrac.getIme(), this.getNaziv(), a, b);


        while (i < brojKoraka) {

            matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()] = this;
            mc.postaviFiguru(trenutnaPozicija.getX(), trenutnaPozicija.getY(), this.getSkracenica(), this.getBoja());
            figuraPresla.add(trenutnaPozicija);
            if (Main.matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()] instanceof GhostFigure) {
                brojDodatnihBodova++;
                mc.skloniDiamond(trenutnaPozicija.getX(), trenutnaPozicija.getY());
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (trenutnaPozicija == krajnjaPozicija) {
                setZavrsila(true);
            }
            //nzm kako uzeti narendu poziciju iz hashMape lol
            boolean found = false;
            Integer nextKey = -1;
            for (Integer key : Main.putanjaFigure.keySet()) {
                if (!found) {
                    nextKey = key.intValue();
                    found = true;
                }
            }
            found = false;
            mc.skloniFiguru(trenutnaPozicija.getX(), trenutnaPozicija.getY());
            matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()] = null;

            int pomPoz = valueList.indexOf(trenutnaPozicija) + 1;
            int krajPoz = valueList.indexOf(krajnjaPozicija);
            if (pomPoz > krajPoz) {
                setZavrsila(true);
            } else {
                trenutnaPozicija = Main.putanjaFigure.get(nextKey);
            }

            setDodatniKoraci(brojDodatnihBodova);
            i++;
        }
    }

}
