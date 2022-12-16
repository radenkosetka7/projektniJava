package com.example.projektnijava.game;

import javafx.scene.image.Image;

import java.io.File;

public abstract class Card {
    public String putanja;

    public Card() {
    }

    public Card(String putanja) {
        this.putanja = putanja;
    }

    public Image getSlika()
    {
        return new Image(new File(putanja).toURI().toString(),250,250,false,false);
    }

}
