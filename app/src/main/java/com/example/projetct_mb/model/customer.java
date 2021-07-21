package com.example.projetct_mb.model;

import java.io.Serializable;

public class customer implements Serializable {
    private int IdCus;
    private String NameCus;
    private String UserCus;
    private String PassCus;
    private String PhoneCus;
    private String DateCus;
    private String AddressCus;
    private String EmailCus;
    private byte[] ImgCus;
    public customer(){}
    public customer(int idCus, String userCus, String passCus, String phoneCus, String emailCus) {
        IdCus = idCus;
        UserCus = userCus;
        PassCus = passCus;
        PhoneCus = phoneCus;
        EmailCus = emailCus;
    }

    public customer(int idCus, String nameCus, String userCus, String passCus, String phoneCus, String dateCus, String addressCus, String emailCus, byte[] imgCus) {
        IdCus = idCus;
        NameCus = nameCus;
        UserCus = userCus;
        PassCus = passCus;
        PhoneCus = phoneCus;
        DateCus = dateCus;
        AddressCus = addressCus;
        EmailCus = emailCus;
        ImgCus = imgCus;
    }

    public customer(String nameCus, String userCus, String passCus, String phoneCus, String dateCus, String addressCus, String emailCus, byte[] imgCus) {
        NameCus = nameCus;
        UserCus = userCus;
        PassCus = passCus;
        PhoneCus = phoneCus;
        DateCus = dateCus;
        AddressCus = addressCus;
        EmailCus = emailCus;
        ImgCus = imgCus;
    }

    public int getIdCus() {
        return IdCus;
    }

    public void setIdCus(int idCus) {
        IdCus = idCus;
    }

    public String getNameCus() {
        return NameCus;
    }

    public void setNameCus(String nameCus) {
        NameCus = nameCus;
    }

    public String getUserCus() {
        return UserCus;
    }

    public void setUserCus(String userCus) {
        UserCus = userCus;
    }

    public String getPassCus() {
        return PassCus;
    }

    public void setPassCus(String passCus) {
        PassCus = passCus;
    }

    public String getPhoneCus() {
        return PhoneCus;
    }

    public void setPhoneCus(String phoneCus) {
        PhoneCus = phoneCus;
    }

    public String getDateCus() {
        return DateCus;
    }

    public void setDateCus(String dateCus) {
        DateCus = dateCus;
    }

    public String getAddressCus() {
        return AddressCus;
    }

    public void setAddressCus(String addressCus) {
        AddressCus = addressCus;
    }

    public String getEmailCus() {
        return EmailCus;
    }

    public void setEmailCus(String emailCus) {
        EmailCus = emailCus;
    }

    public byte[] getImgCus() {
        return ImgCus;
    }

    public void setImgCus(byte[] imgCus) {
        ImgCus = imgCus;
    }
}
