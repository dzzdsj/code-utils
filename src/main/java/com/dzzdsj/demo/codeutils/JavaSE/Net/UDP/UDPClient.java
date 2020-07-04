package com.dzzdsj.demo.codeutils.JavaSE.Net.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        byte[] buf = "hello".getBytes();
        DatagramPacket dp = new DatagramPacket(buf, 0, buf.length,
                new InetSocketAddress("127.0.0.1", 8888));
        DatagramSocket ds = new DatagramSocket(9999);
        ds.send(dp);
        ds.close();
    }
}
