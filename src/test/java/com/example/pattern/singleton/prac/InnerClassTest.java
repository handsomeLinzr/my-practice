package com.example.pattern.singleton.prac;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/30 11:01 上午
 * @since V1.0.0
 */
public class InnerClassTest {

    @Test
    public void test1() {
        System.out.println(InnerClass.InnerInner.innerString);
    }
}
