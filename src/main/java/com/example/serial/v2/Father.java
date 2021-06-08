package com.example.serial.v2;

import java.io.Serializable;

public class Father implements Serializable {
    private String fatherName;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

}
