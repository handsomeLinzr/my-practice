package com.example.pattern.prototype.simple;

import java.util.List;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 10:57 上午
 * @since V1.0.0
 */
public class ConPrototypeB implements Cloneable{
    private String name;
    private int age;
    private List<String> hobbies;

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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public ConPrototypeB() {
        System.out.println("constructor");
    }

    @Override
    protected ConPrototypeB clone() throws CloneNotSupportedException {
        return (ConPrototypeB) super.clone();
    }
}
