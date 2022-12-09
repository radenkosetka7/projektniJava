package com.example.projektnijava.game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.projektnijava.game.Main.mc;

public class GhostFigure extends Thread{

    public List<Position> dijamanti=new ArrayList<>();

    public GhostFigure()
    {

    }

    public void run()
    {
        while(!Main.simulacijaZavrsena)
        {
            synchronized (Main.pauza)
            {
                if(Main.pauziranaSimulacija)
                {
                    try
                    {
                        Main.pauza.wait();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            Random random=new Random();
            int brojDijamanata=random.nextInt(Main.dimenzijaMatrice-2)+2;
            int i=0;
            while(i<brojDijamanata)
            {
                List<Integer> valueList=new ArrayList<Integer>(Main.putanjaFigure.keySet());
                Integer randomNum=valueList.get(random.nextInt(valueList.size()));
                Position pozicija=Main.putanjaFigure.get(randomNum);
                if(Main.matrica[pozicija.getX()][pozicija.getY()]==null)
                {
                    Diamond dijamant=new Diamond();
                    Main.matrica[pozicija.getX()][pozicija.getY()]=dijamant;
                    mc.postaviDiamond(pozicija.getX(),pozicija.getY());
                    dijamanti.add(pozicija);
                    i++;
                }
            }
            try
            {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obrisiDijamante();
        }
    }

    private void obrisiDijamante()
    {
        for(Position dijamant:dijamanti)
        {
            mc.skloniDiamond(dijamant.getX(),dijamant.getY());
            dijamanti.remove(dijamant);
        }
        dijamanti.clear();
    }
}
