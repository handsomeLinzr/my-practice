package com.example.pattern.proxy.simple;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/11 9:32 上午
 * @since V1.0.0
 */
public class SimpleProxyTest {

    @Test
    public void test1() {
        Son son = new Son();
//        son.findLove();
        Father father = new Father(son);
        // father 代理 son 对方法进行访问
        father.findLove();
    }

}
