package com.example.projektnijava.game;

import java.nio.file.Path;

public class OrdinaryCard extends Card{

    private int brojPolja;
    public OrdinaryCard() {
    }

    public OrdinaryCard(String path)
    {
        super(path);
        String fajl= Path.of(path).getFileName().toString();
        String[] parts=fajl.split("\\.");
        this.brojPolja=Integer.parseInt(parts[0]);
    }

    public int getBrojPolja() {
        return brojPolja;
    }

    public void setBrojPolja(int brojPolja) {
        this.brojPolja = brojPolja;
    }
}
