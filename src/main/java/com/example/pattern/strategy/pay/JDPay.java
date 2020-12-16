package com.example.pattern.strategy.pay;

/**
 * @author LZR
 * @date 2020/12/17-0:00
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 300;
    }
}
