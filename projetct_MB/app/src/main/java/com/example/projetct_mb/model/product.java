package com.example.projetct_mb.model;

import java.io.Serializable;

public class product implements Serializable {
    public int ID;
    public String Tensanpham;
    public double Giasanpham;
    public String Hinhanhsanpham;
    public String Motasanpham;
    public int IDSanpham;
    public product(){}

    public product(String tensanpham, double giasanpham, String hinhanhsanpham, String motasanpham, int IDSanpham) {
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        Hinhanhsanpham = hinhanhsanpham;
        Motasanpham = motasanpham;
        this.IDSanpham = IDSanpham;
    }

    public product(int ID, String tensanpham, double giasanpham, String hinhanhsanpham, String motasanpham, int IDSanpham) {
        this.ID = ID;
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        Hinhanhsanpham = hinhanhsanpham;
        Motasanpham = motasanpham;
        this.IDSanpham = IDSanpham;
    }

    public product(String tensanpham,double giasanpham ) {
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
    }

    public product(String tensanpham, String hinhanhsanpham, String motasanpham) {
        Tensanpham = tensanpham;
        Hinhanhsanpham = hinhanhsanpham;
        Motasanpham = motasanpham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        Tensanpham = tensanpham;
    }

    public double getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(double giasanpham) {
        Giasanpham = giasanpham;
    }

    public String getHinhanhsanpham() {
        return Hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        Hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return Motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        Motasanpham = motasanpham;
    }

    public int getIDSanpham() {
        return IDSanpham;
    }

    public void setIDSanpham(int IDSanpham) {
        this.IDSanpham = IDSanpham;
    }
}

