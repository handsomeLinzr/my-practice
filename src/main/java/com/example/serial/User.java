package com.example.serial;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;

public class User extends People implements Serializable {

    private static final long serialVersionUID = 1211194368054380134L;

    private transient String name;
    private Integer age;

    private void writeObject(ObjectOutputStream s)
            throws java.io.IOException{
        s.defaultWriteObject();
        s.writeObject(name);
    }

    private void readObject(ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        name = (String) s.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
