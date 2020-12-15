package com.example.pattern.delegate.simple;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/15 4:19 下午
 * @since V1.0.0
 */
public class SimpleDelegateTest {

    // 老板给经理下任务，经理委派给员工A工作
    @Test
    public void test1() {
        Boss boss = new Boss();
        boss.work("加密", new Leader());
    }

    // 老板给经理下任务，经理委派给员工A工作
    @Test
    public void test2() {
        Boss boss = new Boss();
        boss.work("架构", new Leader());
    }

    @Test
    public void test3() {
        Boss boss = new Boss();
        boss.work("逻辑", new Leader());
    }

}
