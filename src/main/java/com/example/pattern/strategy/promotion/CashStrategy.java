package com.example.pattern.strategy.promotion;

/**
 * Description: 返现活动
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 7:29 下午
 * @since V1.0.0
 */
public class CashStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现现金到支付宝");
    }
}
