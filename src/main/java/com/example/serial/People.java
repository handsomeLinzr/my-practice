package com.example.serial;

import java.io.Serializable;

public class People implements Serializable {

    private static final long serialVersionUID = 3996100086319770968L;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
