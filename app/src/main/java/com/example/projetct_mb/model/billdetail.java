package com.example.projetct_mb.model;

import java.io.Serializable;

public class billdetail implements Serializable {
    private int IdDetail;
    private int IdPro;
    private int IdBill;
    private int Amount;
    private double TotalDetail;

    public billdetail(int idDetail, int idPro, int idBill, int amount, double totalDetail) {
        IdDetail = idDetail;
        IdPro = idPro;
        IdBill = idBill;
        Amount = amount;
        TotalDetail = totalDetail;
    }

    public billdetail(int idPro, int idBill, int amount, double totalDetail) {
        IdPro = idPro;
        IdBill = idBill;
        Amount = amount;
        TotalDetail = totalDetail;
    }

    public int getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(int idDetail) {
        IdDetail = idDetail;
    }

    public int getIdPro() {
        return IdPro;
    }

    public void setIdPro(int idPro) {
        IdPro = idPro;
    }

    public int getIdBill() {
        return IdBill;
    }

    public void setIdBill(int idBill) {
        IdBill = idBill;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public double getTotalDetail() {
        return TotalDetail;
    }

    public void setTotalDetail(double totalDetail) {
        TotalDetail = totalDetail;
    }
}
