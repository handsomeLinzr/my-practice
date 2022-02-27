package com.example.juc.mashibing;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/2/23 11:44 下午
 */
public class MashibingCollection {

    private static final Integer MAX_SIZE = 1000000;
    private static final Integer THREAD_COUNT = 1000;
    private static final Thread[] THREADS = new Thread[THREAD_COUNT];
    private static final UUID[] KEY = new UUID[MAX_SIZE];
    private static final UUID[] VALUE = new UUID[MAX_SIZE];
    static {
        for (int i = 0; i < MAX_SIZE; i++) {
            KEY[i] = UUID.randomUUID();
            VALUE[i] = UUID.randomUUID();
        }
    }

    public static void main(String[] args) {
        MashibingCollection collection = new MashibingCollection();
        try {
            collection.testGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testPut() throws Exception{
//        Map<UUID, UUID> hashmap = Collections.synchronizedMap(new HashMap<>(MAX_SIZE));
        Hashtable<UUID, UUID> hashmap = new Hashtable<>(MAX_SIZE);
//        HashMap<UUID, UUID> hashmap = new HashMap<>(MAX_SIZE);
//        ConcurrentHashMap<UUID, UUID> hashmap = new ConcurrentHashMap<>(MAX_SIZE);
        for (int i = 0; i < THREAD_COUNT; i++) {
            THREADS[i] = new Thread(new HashtableThread(i, hashmap));
        }
        long start = System.currentTimeMillis();
        for (Thread thread : THREADS) {
            thread.start();
        }
        for (Thread thread : THREADS) {
            thread.join();
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(hashmap.size());
    }

    private void testGet() throws Exception {
        ConcurrentHashMap<UUID, UUID> hashmap = new ConcurrentHashMap<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            hashmap.put(KEY[i], VALUE[i]);
        }
        System.out.println("SIZE:" + hashmap.size());
        for (int i = 0; i < THREAD_COUNT; i++) {
            THREADS[i] = new Thread(new GetThread(hashmap));
        }
        long start = System.currentTimeMillis();
        for (Thread thread : THREADS) {
            thread.start();
        }
        for (Thread thread : THREADS) {
            thread.join();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * Hashtable    367
     */
    static class HashtableThread implements Runnable {
        // 开始位置
        int start;
        // 间隙多少
        int gap = MAX_SIZE/THREAD_COUNT;
        int from;
        Hashtable<UUID, UUID> hashtable;
        public HashtableThread(int start, Hashtable<UUID, UUID> hashtable) {
            this.start = start;
            this.hashtable = hashtable;
            from = start * gap;
        }
        @Override
        public void run() {
            for (int i = 0; i < gap; i++) {
                hashtable.put(KEY[from+i], VALUE[from+i]);
            }
        }
    }

    /**
     * Hashmap  349 数目不对 异常
     */
    static class HashmapThread implements Runnable {
        // 开始位置
        int start;
        // 间隙多少
        int gap = MAX_SIZE/THREAD_COUNT;
        int from;
        HashMap<UUID, UUID> hashMap;
        public HashmapThread(int start, HashMap<UUID, UUID> hashMap) {
            this.start = start;
            this.hashMap = hashMap;
            from = start * gap;
        }
        @Override
        public void run() {
            for (int i = 0; i < gap; i++) {
                hashMap.put(KEY[from+i], VALUE[from+i]);
            }
        }
    }

    /**
     * 346
     */
    static class ConcurrentThread implements Runnable {
        // 开始位置
        int start;
        // 间隙多少
        int gap = MAX_SIZE/THREAD_COUNT;
        int from;
        ConcurrentHashMap<UUID, UUID> hashMap;
        public ConcurrentThread(int start, ConcurrentHashMap<UUID, UUID> hashMap) {
            this.start = start;
            this.hashMap = hashMap;
            from = start * gap;
        }
        @Override
        public void run() {
            for (int i = 0; i < gap; i++) {
                hashMap.put(KEY[from+i], VALUE[from+i]);
            }
        }
    }

    /**
     * 517
     */
    static class SynchronizedHashMapThread implements Runnable {
        // 开始位置
        int start;
        // 间隙多少
        int gap = MAX_SIZE/THREAD_COUNT;
        int from;
        Map<UUID, UUID> hashMap;
        public SynchronizedHashMapThread(int start, Map<UUID, UUID> hashMap) {
            this.start = start;
            this.hashMap = hashMap;
            from = start * gap;
        }
        @Override
        public void run() {
            for (int i = 0; i < gap; i++) {
                hashMap.put(KEY[from+i], VALUE[from+i]);
            }
        }
    }

    static class GetThread implements Runnable {

//        private Hashtable<UUID, UUID> hashtable;   670
//        private HashMap<UUID, UUID> hashtable;  170
//        private Map<UUID, UUID> hashtable;   530
        private ConcurrentHashMap<UUID, UUID> hashtable;  // 130
        public GetThread(ConcurrentHashMap<UUID, UUID> hashtable) {
            this.hashtable = hashtable;
        }
        @Override
        public void run() {
            Random r = new Random();
            for (int i = 0; i < 1000; i++) {
                hashtable.get(KEY[r.nextInt(MAX_SIZE)]);
            }
        }
    }

}
