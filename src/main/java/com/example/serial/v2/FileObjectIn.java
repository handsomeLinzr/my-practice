package com.example.serial.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FileObjectIn {

    public static void main(String[] args) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("user")))){
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
