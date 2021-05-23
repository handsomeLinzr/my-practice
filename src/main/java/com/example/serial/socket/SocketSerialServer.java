package com.example.serial.socket;

import com.example.serial.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketSerialServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(8080);
        Socket client = server.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
        User user = (User) objectInputStream.readObject();
        System.out.println(user.getAddress());
        System.out.println(user);
    }

}
