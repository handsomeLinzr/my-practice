package com.example.pattern.strategy.pay;

/**
 * 支付方式抽象
 * @author LZR
 * @date 2020/12/16-23:43
 */
public abstract class Payment {
    /**
     * 获得支付方式名称
     * @return
     */
    public abstract String getName();

    /**
     * 获得余额
     * @param uid
     * @return
     */
    public abstract double queryBalance(String uid);

    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "支付失败", "余额不足");
        }
        return new PayState(200, "支付成功", String.format("支付金额：%s;余额：%s", amount, queryBalance(uid) - amount));
    }

}
