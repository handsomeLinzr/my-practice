package com.example.serial.v2;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 10001);
             ObjectOutputStream objectInputStream = new ObjectOutputStream(socket.getOutputStream())){
            User user = new User();
            user.setName("123");
            user.setAge(22);
            objectInputStream.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
