package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.projektnijava.contollers.MainController.mc;
import static com.example.projektnijava.game.MyLogger.logger;
import static java.lang.Thread.sleep;

public class SpecialCard extends Card{

    List<Position> rupe=new ArrayList<>();
    public SpecialCard() {
    }

    public SpecialCard(String path) {
        super(path);
    }


    public void dodajRupu()
    {

       Random random=new Random();
        int brojRupa=random.nextInt(Main.dimenzijaMatrice-2)+2;
        int i=0;
        mc.znacenjeKarte(brojRupa);
        while(i<brojRupa)
        {
            List<Integer> valueList=new ArrayList<Integer>(Main.putanjaFigure.keySet());
            Integer randomNum=valueList.get(random.nextInt(valueList.size()));
            Position pozicija=Main.putanjaFigure.get(randomNum);
            if(Main.matrica[pozicija.getX()][pozicija.getY()].getHole()==null)
            {
                Hole hole=new Hole();
                rupe.add(pozicija);
                Main.matrica[pozicija.getX()][pozicija.getY()].setHole(hole);
                mc.postaviRupu(pozicija.getX(),pozicija.getY());
                i++;
                if(Main.matrica[pozicija.getX()][pozicija.getY()].getFigure()!=null &&
                    !(Main.matrica[pozicija.getX()][pozicija.getY()].getFigure() instanceof HoverFigure))
                {
                    Figure figura=Main.matrica[pozicija.getX()][pozicija.getY()].getFigure();
                    figura.setZavrsila(true);
                    int labela=mc.getKey(pozicija);
                    mc.skloniFiguru(pozicija.getX(), pozicija.getY(),labela);
                    Main.matrica[pozicija.getX()][pozicija.getY()].setFigure(null);
                }
            }
        }
        try
        {
            sleep(1000);
        } catch (InterruptedException e) {
            logger.severe(e.fillInStackTrace().toString());

        }
        ukloniRupe();

    }

    private void ukloniRupe()
    {
        for(Position rupa:rupe)
        {
            if(Main.matrica[rupa.getX()][rupa.getY()].getFigure()!=null &&
                Main.matrica[rupa.getX()][rupa.getY()].getFigure() instanceof HoverFigure)
            {
                mc.skloniRupu(rupa.getX(), rupa.getY());
                Main.matrica[rupa.getX()][rupa.getY()].setHole(null);
                mc.postaviFiguru(rupa.getX(),rupa.getY(),Main.matrica[rupa.getX()][rupa.getY()].getFigure().getSkracenica(),Main.matrica[rupa.getX()][rupa.getY()].getFigure().getBoja());
            }
            else {
                mc.skloniRupu(rupa.getX(), rupa.getY());
                Main.matrica[rupa.getX()][rupa.getY()].setHole(null);
            }
            //rupe.remove(rupa);
        }
        rupe.clear();
    }
}
