package com.dzzdsj.demo.codeutils.JavaSE.Net.TCP;


import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 6666);
        System.out.println("connect success");
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("hello server");
        dos.writeUTF("" + s.getInetAddress() + ":" + s.getPort());
        dos.flush();
        dos.close();
        s.close();
    }
}
