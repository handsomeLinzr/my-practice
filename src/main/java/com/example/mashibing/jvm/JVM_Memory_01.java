package com.example.mashibing.jvm;

//import sun.misc.VM;
//import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/3/29 12:56 下午
 */
public class JVM_Memory_01 {

    public static void main(String[] args) {
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024);
        List<byte[]> arrList = new ArrayList<>();
        for(;;) {
            arrList.add(new byte[1024*512]);
        }
    }

}

