package com.example.serial.v2;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(10001);
             Socket socket = serverSocket.accept();
             ObjectInputStream objectOutputStream = new ObjectInputStream(socket.getInputStream())){
            User user = (User) objectOutputStream.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
