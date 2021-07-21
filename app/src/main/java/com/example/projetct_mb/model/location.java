package com.example.projetct_mb.model;

import java.io.Serializable;

public class location implements Serializable {
    public int ID;
    public String Diachi;

    public location(String diachi) {
        Diachi = diachi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
}

