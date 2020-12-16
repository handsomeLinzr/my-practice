package com.example.pattern.strategy.promotion;

/**
 * Description: 拼团活动
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 7:30 下午
 * @since V1.0.0
 */
public class GroupStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团活动");
    }
}
