package com.example.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 10011)){
            // 获得连接的输出流，并连接到控制台
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//            pw.println("hello");
            Scanner scanner = new Scanner(System.in);
            String content;
            while (!"byte".equals(content = scanner.nextLine())) {
                pw.println(content);
            }
            pw.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
