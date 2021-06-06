package com.example.socket;

import java.io.*;
import java.net.Socket;

/**
 * 全双工聊天客户端
 */
public class ChatClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1009);
             // 服务端输入流
             BufferedReader sReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // 控制台输入
             BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));
             // 服务器输出流
             PrintWriter sWriter = new PrintWriter(socket.getOutputStream(), true)){
            System.out.println("Server:" + sReader.readLine());
            String sysContent;
            while (!"bye".equals(sysContent = sysReader.readLine())) {
                sWriter.println(sysContent);
                System.out.println("Server:" + sReader.readLine());
            }
            sWriter.println(sysContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
