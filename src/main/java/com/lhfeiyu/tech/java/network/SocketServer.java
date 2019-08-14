package com.lhfeiyu.tech.java.network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author airson
 */
public class SocketServer {

    public static void main(String[] args) {
        initServer();
    }

    public static void initServer() {

        try {

            // 初始化服务端socket并且绑定9999端口
            ServerSocket server = new ServerSocket(9999);
            //等待客户端的连接
            Socket socket = server.accept();
            //获取输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();

            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
