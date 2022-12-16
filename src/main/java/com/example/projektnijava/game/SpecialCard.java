package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.example.projektnijava.contollers.MainController.mc;
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

       /* Random random=new Random();
        int brojRupa=random.nextInt(Main.dimenzijaMatrice-2)+2;
        int i=0;
        mc.znacenjeKarte(brojRupa);
        while(i<brojRupa)
        {
            List<Integer> valueList=new ArrayList<Integer>(Main.putanjaFigure.keySet());
            Integer randomNum=valueList.get(random.nextInt(valueList.size()));
            Position pozicija=Main.putanjaFigure.get(randomNum);
            if(!(Main.matrica[pozicija.getX()][pozicija.getY()] instanceof Hole))
            {
                Hole hole=new Hole();
                rupe.add(pozicija);
                Main.matrica[pozicija.getX()][pozicija.getY()]=hole;
                mc.postaviRupu(pozicija.getX(),pozicija.getY());
                i++;
                if(Main.matrica[pozicija.getX()][pozicija.getY()] instanceof Figure &&
                    !(Main.matrica[pozicija.getX()][pozicija.getY()] instanceof SuperFastInterface))
                {
                    Figure figura=(Figure)Main.matrica[pozicija.getX()][pozicija.getY()];
                    figura.setZavrsila(true);
                    mc.skloniFiguru(pozicija.getX(),pozicija.getY());
                    Main.matrica[pozicija.getX()][pozicija.getY()]=null;
                }
            }
        }
        try
        {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ukloniRupe();*/

    }

    private void ukloniRupe()
    {
        for(Position rupa:rupe)
        {
           mc.skloniRupu(rupa.getX(), rupa.getY());
           rupe.remove(rupa);
        }
        rupe.clear();
    }
}
