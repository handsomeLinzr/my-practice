package com.example.pattern.prototype.simple;

import java.util.List;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 10:05 上午
 * @since V1.0.0
 */
public class ConPrototype implements Prototype{

    public String name;
    public int age;
    public List<String> hobbies;

    public ConPrototype() {
        System.out.println("constructor");
    }

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

    @Override
    public ConPrototype clone() {
        ConPrototype conPrototype = new ConPrototype();
        conPrototype.setAge(this.age);
        conPrototype.setName(this.name);
        conPrototype.setHobbies(this.hobbies);
        return conPrototype;
    }
}
