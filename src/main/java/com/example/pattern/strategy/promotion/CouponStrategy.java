package com.example.pattern.strategy.promotion;

/**
 * Description: 优惠券优惠
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 5:30 下午
 * @since V1.0.0
 */
public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取内部优惠券");
    }
}
