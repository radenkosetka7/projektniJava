package com.example.projektnijava.game;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.example.projektnijava.contollers.MainController.mc;
import static com.example.projektnijava.game.Main.*;

public class HoverFigure extends Figure {

    public HoverFigure(ColorOfFIgure boja) {
        super(boja,"LF");
    }

    @Override
    public void kreni(Player igrac, int brojKoraka) {

        starTimer=System.currentTimeMillis();
        if(trenutnaPozicija.equals(pocetnaPozicija))
        {
            figuraPresla.add(trenutnaPozicija);
            mc.postaviFiguru(trenutnaPozicija.getX(),trenutnaPozicija.getY(),this.getSkracenica(),this.getBoja());
        }
        int i=0;
        brojKoraka+=getDodatniKoraci();
        setDodatniKoraci(0);
        Integer pozicija = valueList.indexOf(trenutnaPozicija);
        Position tmpPosition=null;
        if(pozicija+brojKoraka>=valueList.size())
        {
            tmpPosition=valueList.get(valueList.size()-1);
        }
        else {
            tmpPosition = valueList.get(pozicija + brojKoraka);
        }
        if(matrica[tmpPosition.getX()][tmpPosition.getY()].getFigure()!=null)
        {
            while(true)
            {
                brojKoraka++;
                Position tmpPosition2 = valueList.get(pozicija + brojKoraka);
                if (matrica[tmpPosition2.getX()][tmpPosition2.getY()].getFigure()==null) {
                    break;
                }

            }
        }
        Position odredisnaPozicija=null;
        if(pozicija+brojKoraka>=valueList.size())
        {
            odredisnaPozicija=valueList.get(valueList.size()-1);
        }
        else {
            odredisnaPozicija = valueList.get(pozicija + brojKoraka);
        }
        int a=mc.getKey(trenutnaPozicija);
        int b=mc.getKey(odredisnaPozicija);
        mc.znacenjeKarte(igrac.getIme(), this.getNaziv(), a, b,brojKoraka);
        while(!trenutnaPozicija.equals(odredisnaPozicija))
        {
            if(matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].getDiamond()!=null)
            {
                dodatniKoraci++;
                matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].setDiamond(null);
                mc.skloniDiamond(trenutnaPozicija.getX(),trenutnaPozicija.getY());
            }
            Integer tempPosition=valueList.indexOf(trenutnaPozicija);
            Position narednaPozicija=valueList.get(tempPosition+1);
            if(matrica[narednaPozicija.getX()][narednaPozicija.getY()].getFigure()!=null)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Logger.getLogger(MyLogger.class.getName()).severe(e.fillInStackTrace().toString());
                }
                if(!(matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].getFigure()!=null &&
                        matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].getFigure()!=this))
                {
                    int key = mc.getKey(trenutnaPozicija);
                    mc.skloniFiguru(trenutnaPozicija.getX(), trenutnaPozicija.getY(), key);
                    matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].setFigure(null);
                }
                trenutnaPozicija=narednaPozicija;
                figuraPresla.add(trenutnaPozicija);
                continue;
            }
            else if(matrica[narednaPozicija.getX()][narednaPozicija.getY()].getFigure()==null)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Logger.getLogger(MyLogger.class.getName()).severe(e.fillInStackTrace().toString());
                }
                if(!(matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].getFigure()!=null &&
                        matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].getFigure()!=this))
                {
                    int key = mc.getKey(trenutnaPozicija);
                    mc.skloniFiguru(trenutnaPozicija.getX(), trenutnaPozicija.getY(), key);
                    matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].setFigure(null);
                }
                trenutnaPozicija=narednaPozicija;
                figuraPresla.add(trenutnaPozicija);
                mc.postaviFiguru(trenutnaPozicija.getX(),trenutnaPozicija.getY(),this.getSkracenica(),this.getBoja());
                matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].setFigure(this);
            }
        }
        if(matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].getDiamond()!=null)
        {
            dodatniKoraci++;
            matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].setDiamond(null);
            mc.skloniDiamond(trenutnaPozicija.getX(),trenutnaPozicija.getY());
        }
        Position zavrsnaPozicija=valueList.get(valueList.size()-1);
        long endTimer=System.currentTimeMillis();
        vrijemeKretanja+=(endTimer-starTimer);
        if(trenutnaPozicija.equals(zavrsnaPozicija))
        {
            this.setZavrsila(true);
            this.setUspjesnoZavrsila(true);
            int key=mc.getKey(trenutnaPozicija);
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getLogger(MyLogger.class.getName()).severe(e.fillInStackTrace().toString());

            }
            mc.skloniFiguru(trenutnaPozicija.getX(),trenutnaPozicija.getY(),key);
            matrica[trenutnaPozicija.getX()][trenutnaPozicija.getY()].setFigure(null);
            vrijemeKretanja/=1000;

        }
    }
    }

