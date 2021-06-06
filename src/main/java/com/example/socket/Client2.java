package com.example.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 10011);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader sReader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println(reader.readLine());
            String content;
            while (!"bye".equals(content=sReader.readLine())) {
                printWriter.println(content);
            }
            printWriter.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
