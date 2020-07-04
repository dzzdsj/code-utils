package com.dzzdsj.demo.codeutils.JavaSE.IO.NIO;

import java.nio.ByteBuffer;

public class TestNIO {
    public static void main(String[] args) {

        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 看一下初始时4个核心变量的值
        //上界Limit,缓冲区里的数据的总数，代表了当前缓冲区中一共有多少数据
        System.out.println("初始时-->limit--->" + byteBuffer.limit());
        //下一个要被读或写的元素的位置。Position会自动由相应的 get( )和 put( )函数更新
        System.out.println("初始时-->position--->" + byteBuffer.position());
        //缓冲区能够容纳的数据元素的最大数量。容量在缓冲区创建时被设定，并且永远不能被改变
        System.out.println("初始时-->capacity--->" + byteBuffer.capacity());
        //用于记录上一次读写的位置
        System.out.println("初始时-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        // 添加一些数据到缓冲区中
        String s = "Java3y";
        byteBuffer.put(s.getBytes());  //存入数据到缓冲区

        System.out.println("put完之后-->limit--->" + byteBuffer.limit());
        System.out.println("put完之后-->position--->" + byteBuffer.position());
        System.out.println("put完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());


        System.out.println("--------------------------------------");

        //每当要从缓存区的时候读取数据时，就调用filp()“切换成读模式”
        byteBuffer.flip();//当调用完filp()时,会改动position和limit的位置：limit是限制读到哪里，而position是从哪里读

        System.out.println("flip完之后-->limit--->" + byteBuffer.limit());
        System.out.println("flip完之后-->position--->" + byteBuffer.position());
        System.out.println("flip完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("flip完之后-->mark--->" + byteBuffer.mark());

        System.out.println("---------------输出数据----------------");
        // 创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[byteBuffer.limit()];

        // 将读取的数据装进我们的字节数组中
        byteBuffer.get(bytes); //从缓冲区获取数据

        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("get完之后-->limit--->" + byteBuffer.limit());
        System.out.println("get完之后-->position--->" + byteBuffer.position());
        System.out.println("get完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("get完之后-->mark--->" + byteBuffer.mark());
        System.out.println("--------------------------------------");

        //清空缓冲区，核心变量回归写模式，缓冲区数据是没有被清空的，但是被“遗忘”了,因为操作数据的核心变量都被清空了
        byteBuffer.clear();
        System.out.println("clear完之后-->limit--->" + byteBuffer.limit());
        System.out.println("clear完之后-->position--->" + byteBuffer.position());
        System.out.println("clear完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("clear完之后-->mark--->" + byteBuffer.mark());

//        byteBuffer.get(bytes);
//        System.out.println(new String(bytes, 0, bytes.length));
    }
}
