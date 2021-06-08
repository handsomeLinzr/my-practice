package com.example.serial.v2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileObjectOut {

    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("user")))){
            Sun user = new Sun();
            user.setB("456");

            User user1 = new User();
            user1.setName("12345");
            user1.setSun(user);
            objectOutputStream.writeObject(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
