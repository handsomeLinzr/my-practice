package com.example.pattern.process;

import java.util.concurrent.TimeUnit;

/**
 * 责任链模式练习
 */
public class ProcessTest {

    public static void main(String[] args) throws InterruptedException {
        // pre——>save——>print
        PrintProcessor print = new PrintProcessor(null);
        print.start();
        SaveProcessor save = new SaveProcessor(print);
        save.start();
        PreProcessor pre = new PreProcessor(save);
        pre.start();
        Request request1 = new Request("离职申请");
        Request request2 = new Request("入职申请");
        pre.process(request1);
        pre.process(request2);

        TimeUnit.SECONDS.sleep(5);
        print.shutdown();
        save.shutdown();
        pre.shutdown();
        pre.process(request1);
    }
}
