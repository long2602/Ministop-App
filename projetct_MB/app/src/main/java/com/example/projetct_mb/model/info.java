package com.example.projetct_mb.model;

import com.example.projetct_mb.R;

public class info {
    String name;
    String hinh;

    public info(String name, String hinh) {
        this.name = name;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
