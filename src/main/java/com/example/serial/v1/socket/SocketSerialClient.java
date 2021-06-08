package com.example.serial.v1.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketSerialClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        User user = new User();
        user.setName("阿哲");
        user.setAge(22);
        user.setAddress("address");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);

    }
}
