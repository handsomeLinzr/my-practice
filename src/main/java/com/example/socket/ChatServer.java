package com.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 全双工聊天服务端
 */
public class ChatServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1009);
             Socket socket = serverSocket.accept();
             // 控制台输入
             BufferedReader sReader = new BufferedReader(new InputStreamReader(System.in));
             // 客户端输入
             BufferedReader cReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // 客户端输出
             PrintWriter cWrite = new PrintWriter(socket.getOutputStream(), true)){
            // 连接成功
            cWrite.println("欢迎连接");
            String cContent;
            while (!"bye".equals(cContent = cReader.readLine())) {
                System.out.println("Client:" + cContent);
                cWrite.println(sReader.readLine());
            }
            System.out.println(cContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
