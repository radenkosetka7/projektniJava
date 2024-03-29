package com.example.projektnijava.game;

import java.nio.file.Path;

public class OrdinaryCard extends Card{

    private int brojPolja;//koliko se polja pomjera
    public OrdinaryCard() {
    }

    public OrdinaryCard(String path)
    {
        super(path);
        String fajl= Path.of(path).getFileName().toString();
        String[] parts=fajl.split("\\.");
        this.brojPolja=Integer.parseInt(parts[0].substring(parts[0].length()-1));
    }

    public int getBrojPolja() {
        return brojPolja;
    }

    public void setBrojPolja(int brojPolja) {
        this.brojPolja = brojPolja;
    }
}
