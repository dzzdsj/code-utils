package com.dzzdsj.demo.codeutils.JavaSE.Net.TCP;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String str = null;
            if ((str = dis.readUTF()) != null) {
                System.out.println(str);
            }
            dis.close();
            socket.close();
        }
    }
}
