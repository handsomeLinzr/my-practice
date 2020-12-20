package com.example.pattern.adapter.ac;

/**
 * @author LZR
 * @date 2020/12/20-22:09
 */
public class DC5Adapter implements DC5 {

    private AC220 ac220;

    public DC5Adapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int input = ac220.outputAC220();
        return input / 44;
    }
}
