//package com.example.mashibing.juc;
//
//import java.lang.ref.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * Description:
// *
// * @author Linzherong
// * @date 2022/2/23 12:52 下午
// */
//public class MashibingReference {
//
//    public static void main(String[] args) throws Exception {
//        MashibingReference reference = new MashibingReference();
//        reference.phantomReference();
//    }
//
//    // 强引用
//    public void strongReference() throws Exception {
//        JucTest1 i = new JucTest1();
//        i = null;
//        System.gc();  // 会 GC
//        System.in.read();
//    }
//
//    // 软引用  堆不够则清理
//    public void softReference() throws Exception {
//        SoftReference<byte[]> softReference = new SoftReference<>(new byte[10*1024*1024]); // 10M
//        System.out.println("第一次======》" + softReference.get());  //有值
//        System.gc();
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(softReference.get());  // gc后还有值，因为堆空间还够
//        byte[] arr = new byte[12*1024*1024];  // 堆内存不够，gc清理软引用
//        System.out.println(softReference.get());  // null
//    }
//
//    // 若引用，gc则清理
//    public void weakReference() throws Exception {
//        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[10*1024*1024]);
//        System.out.println(weakReference.get());
//        System.gc();
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(weakReference.get());
//    }
//
//    // 虚引用
//    public void phantomReference() throws Exception {
//        ReferenceQueue<JucTest1> queue = new ReferenceQueue<>();
//        PhantomReference<JucTest1> reference = new PhantomReference<>(new JucTest1(), queue);  // 虚引用
//        new Thread(()->{
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                byte[] bytes = new byte[2*1024 * 1024];
//                System.out.println("获取=========》" + reference.get());
//            }
//        }).start();
//
//        new Thread(()->{
//            while (true) {
//                Reference<? extends JucTest1> poll = queue.poll();
//                if (poll != null) {
//                    System.out.println("垃圾回收=======》" + poll);
//                }
//            }
//        }).start();
//    }
//
//}
