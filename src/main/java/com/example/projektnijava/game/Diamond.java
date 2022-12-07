package com.example.projektnijava.game;

import java.io.File;

public class Diamond {

    private String putanja;

    public Diamond()
    {
        this.putanja="src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "diamond.png";

    }
    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }
}
