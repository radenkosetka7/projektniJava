package com.example.projektnijava.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public HashMap<Integer,Position> putanjaFigure=new HashMap<>();
    public static int dimenzijaMatrice;
    public static int brojIgraca;
    public void setujPutanjuFigure()
    {
        if(dimenzijaMatrice ==7)
        {
            putanjaFigure.put(4,new Position(0,3));

            putanjaFigure.add(new Polje(new Element(1,4)));

            putanjaFigure.add(new Polje(new Element(2,5)));

            putanjaFigure.add(new Polje(new Element(3,6)));

            putanjaFigure.add(new Polje(new Element(4,5)));

            putanjaFigure.add(new Polje(new Element(5,4)));

            putanjaFigure.add(new Polje(new Element(6,3)));

            putanjaFigure.add(new Polje(new Element(5,2)));

            putanjaFigure.add(new Polje(new Element(4,1)));

            putanjaFigure.add(new Polje(new Element(3,0)));

            putanjaFigure.add(new Polje(new Element(2,1)));
            mapper.put(16,putanjaFigure.get(10));
            putanjaFigure.add(new Polje(new Element(1,2)));
            mapper.put(10,putanjaFigure.get(11));
            putanjaFigure.add(new Polje(new Element(1,3)));
            mapper.put(11,putanjaFigure.get(12));
            putanjaFigure.add(new Polje(new Element(2,4)));
            mapper.put(19,putanjaFigure.get(13));
            putanjaFigure.add(new Polje(new Element(3,5)));
            mapper.put(27,putanjaFigure.get(14));
            putanjaFigure.add(new Polje(new Element(4,4)));
            mapper.put(33,putanjaFigure.get(15));
            putanjaFigure.add(new Polje(new Element(5,3)));
            mapper.put(39,putanjaFigure.get(16));
            putanjaFigure.add(new Polje(new Element(4,2)));
            mapper.put(31,putanjaFigure.get(17));
            putanjaFigure.add(new Polje(new Element(3,1)));
            mapper.put(23,putanjaFigure.get(18));
            putanjaFigure.add(new Polje(new Element(2,2)));
            mapper.put(17,putanjaFigure.get(19));
            putanjaFigure.add(new Polje(new Element(2,3)));
            mapper.put(18,putanjaFigure.get(20));
            putanjaFigure.add(new Polje(new Element(3,4)));
            mapper.put(26,putanjaFigure.get(21));
            putanjaFigure.add(new Polje(new Element(4,3)));
            mapper.put(32,putanjaFigure.get(22));
            putanjaFigure.add(new Polje(new Element(3,2)));
            mapper.put(24,putanjaFigure.get(23));
            putanjaFigure.add(new Polje(new Element(3,3)));
            mapper.put(25,putanjaFigure.get(24));
        }


    }
}
