package com.example.mashibing.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/2/19 1:33 下午
 */
public class MashibingLockSupport {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                if ( i == 5) {
                    LockSupport.park();
                }
            }
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);

    }

}
