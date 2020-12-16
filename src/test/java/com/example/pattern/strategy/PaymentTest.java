package com.example.pattern.strategy;

import com.example.pattern.strategy.pay.Order;
import com.example.pattern.strategy.pay.PayState;
import com.example.pattern.strategy.pay.PaymentStrategy;
import org.junit.jupiter.api.Test;

/**
 * @author LZR
 * @date 2020/12/17-0:14
 */
public class PaymentTest {

    @Test
    public void test1() {
        Order order = new Order("123", "123", 600);
        PayState payState = order.pay(PaymentStrategy.WECHAT);
        System.out.println(payState);
    }

    @Test
    public void test2() {
        Order order = new Order("123", "123", 300);
        PayState payState = order.pay(PaymentStrategy.ALI);
        System.out.println(payState);
    }

}
