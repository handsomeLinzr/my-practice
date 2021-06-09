package com.example.serial.V3.po;

import java.io.Serializable;

/**
 * Description:
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/9 4:34 下午
 * @since V2.0.0
 */
public class User implements Serializable{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
