package com.dzzdsj.demo.codeutils.JavaSE.Net.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        DatagramSocket ds = new DatagramSocket(8888);
        while (true) {
            ds.receive(dp);
            System.out.println(new String(buf, 0, dp.getLength()));
        }
    }
}
