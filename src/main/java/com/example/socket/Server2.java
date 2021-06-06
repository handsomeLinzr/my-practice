package com.example.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * 多线程服务端，避免在IO阻塞
 */
public class Server2 {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(12,
                20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadFactory() {
            int i = 0;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-" + i++);
            }
        });

        try (ServerSocket serverSocket = new ServerSocket(10011)){
            Socket client;
            while ((client = serverSocket.accept()) != null) {
                pool.execute(new SocketHandler(client));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/**
 * 用于处理连接
 */
class SocketHandler implements Runnable {

    private Socket client;

    public SocketHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter pw = new PrintWriter(client.getOutputStream(), true)){
            pw.println("欢迎光临！" + client.getInetAddress().getHostAddress());
            String content;
            while (!"bye".equals(content = reader.readLine())) {
                System.out.println(content);
            }
            System.out.println(content);
            client.close();  // 关闭客户端连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
