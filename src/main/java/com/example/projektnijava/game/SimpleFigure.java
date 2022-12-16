package com.example.projektnijava.game;

import static com.example.projektnijava.game.Main.mc;

public class SimpleFigure extends Figure {

    private int dodatniKoraci = 0;

    public SimpleFigure(ColorOfFIgure boja) {
        super(boja);
    }


    public int getDodatniKoraci() {
        return dodatniKoraci;
    }

    public void setDodatniKoraci(int dodatniKoraci) {
        this.dodatniKoraci = dodatniKoraci;
    }

    @Override
    public void kreni(Player igrac, int brojKoraka) {

        int i = 0;
        int brojDodatnihBodova = 0;
        brojKoraka += getDodatniKoraci();
//       if(brojKoraka> Main.putanjaFigure.size())
//       {
//           //nesto nemam pojma pisem isti kod kao kod sebe moramo smisliti neku foricu s ovim helppp!!!!!!
       // treba nesto nadtimati da nikad ne dodje kao na polje vece od poslednjeg polja odma ovde
//       }

        while (i < brojKoraka) {


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

            if(trenutnaPozicija == krajnjaPozicija)
            {
                break;
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
            trenutnaPozicija = Main.putanjaFigure.get(nextKey);
            setDodatniKoraci(brojDodatnihBodova);
            i++;

        }
    }

}
