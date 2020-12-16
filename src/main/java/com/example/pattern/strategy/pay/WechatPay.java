package com.example.pattern.strategy.pay;

/**
 * @author LZR
 * @date 2020/12/17-0:01
 */
public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 450;
    }
}
