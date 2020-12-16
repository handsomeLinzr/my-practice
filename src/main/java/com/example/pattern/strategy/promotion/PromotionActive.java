package com.example.pattern.strategy.promotion;

/**
 * Description: 优惠活动
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 7:45 下午
 * @since V1.0.0
 */
public class PromotionActive {
    private PromotionStrategy promotionStrategy;

    public PromotionActive(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void exec() {
        this.promotionStrategy.doPromotion();
    }

}
