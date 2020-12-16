package com.example.pattern.strategy.promotion;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 促销活动策略工厂
 * @author LZR
 * @date 2020/12/16-23:25
 */
public class PromotionStrategyFactory {
    private PromotionStrategyFactory() {}

    private static final Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASH, new CashStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUP, new GroupStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.EMPTY, new EmptyStrategy());
    }

    // 获取优惠策略
    public static PromotionStrategy getInstance(String promotionKey) {
//        promotionKey = StringUtils.isEmpty(promotionKey)? PromotionKey.EMPTY: promotionKey;
        if (PROMOTION_STRATEGY_MAP.containsKey(promotionKey)) {
            return PROMOTION_STRATEGY_MAP.get(promotionKey);
        }
        return PROMOTION_STRATEGY_MAP.get(PromotionKey.EMPTY);
    }

    public interface PromotionKey {
        String CASH = "CASH";
        String COUPON = "COUPON";
        String GROUP = "GROUP";
        String EMPTY = "EMPTY";
    }

}
