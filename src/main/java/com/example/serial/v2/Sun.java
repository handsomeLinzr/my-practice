package com.example.serial.v2;

import java.io.Serializable;

public class Sun implements Serializable {
    private static final long serialVersionUID = -5355441881670274372L;
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "b='" + b + '\'' +
                '}';
    }
}
