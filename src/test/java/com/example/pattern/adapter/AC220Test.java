package com.example.pattern.adapter;

import com.example.pattern.adapter.ac.AC220;
import com.example.pattern.adapter.ac.DC5Adapter;
import org.junit.jupiter.api.Test;

/**
 * @author LZR
 * @date 2020/12/20-22:05
 */
public class AC220Test {

    @Test
    public void test1() {
        AC220 ac220 = new AC220();
        System.out.println(String.format("输出交流电 %s V", ac220.outputAC220()));
    }

    // 应用上适配器
    @Test
    public void test2() {
        AC220 ac220 = new AC220();
        DC5Adapter dc5Adapter = new DC5Adapter(ac220);
        System.out.println(String.format("输入交流电 %s V", ac220.outputAC220()));
        System.out.println(String.format("输出直流电 %s V", dc5Adapter.outputDC5()));
    }

}