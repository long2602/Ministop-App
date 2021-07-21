package com.example.projetct_mb.model;

import java.io.Serializable;

public class bill implements Serializable {
    private int IdBill;
    private int IdCus;
    private String DayBill;
    private int AmountBill;
    private double Total;

    public bill(){}
    public bill(int idBill, int idCus, String dayBill, int amountBill, double total) {
        IdBill = idBill;
        IdCus = idCus;
        DayBill = dayBill;
        AmountBill = amountBill;
        Total = total;
    }

    public bill(int idCus, String dayBill, int amountBill, double total) {
        IdCus = idCus;
        DayBill = dayBill;
        AmountBill = amountBill;
        Total = total;
    }

    public int getIdBill() {
        return IdBill;
    }

    public void setIdBill(int idBill) {
        IdBill = idBill;
    }

    public int getIdCus() {
        return IdCus;
    }

    public void setIdCus(int idCus) {
        IdCus = idCus;
    }

    public String getDayBill() {
        return DayBill;
    }

    public void setDayBill(String dayBill) {
        DayBill = dayBill;
    }

    public int getAmountBill() {
        return AmountBill;
    }

    public void setAmountBill(int amountBill) {
        AmountBill = amountBill;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
