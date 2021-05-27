package com.example.block;

public class User {

    private String name;

    private Long point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
