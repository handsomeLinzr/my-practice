package com.example.pattern.strategy.pay;

/**
 * 订单实体
 * @author LZR
 * @date 2020/12/16-23:39
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    // 默认支付
    public PayState pay(){
        return pay(PaymentStrategy.DEFAULT);
    }

    // 根据策略方式支付
    public PayState pay(String payKey) {
        Payment payment = PaymentStrategy.get(payKey);
        System.out.println("支付方式：" + payment.getName());
        return payment.pay(uid, amount);
    }

}
