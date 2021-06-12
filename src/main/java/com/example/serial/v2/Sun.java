package com.example.serial.v2;

import java.io.Serializable;

public class Sun extends Father implements Serializable {
    private static final long serialVersionUID = -5355441881670274372L;
    private String b;
    private Inner inner;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
    public Inner getInner() {
        Inner inner = new Inner();
        inner.setInnerName("gggfffdgd");
        return inner;
    }

    private static class Inner {
        private String innerName;
        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }
        public String getInnerName() {
            return this.innerName;
        }
    }

    @Override
    public String toString() {
        return "Sun{" +
                "b='" + b + '\'' +
                "fatherName='" + getFatherName() + '\''+
                '}' + "inner:" + inner;
    }
}
