package com.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket
 */
public class Server {

    public static void main(String[] args) {
        // try-with-resource 写法
        try (ServerSocket server = new ServerSocket(1008);
             Socket socket = server.accept()) {
            // 获得输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content;
            while (!"byte".equals(content = reader.readLine())) {
                System.out.println(content);
            }
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
