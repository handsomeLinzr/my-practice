package com.example.pattern.strategy;

import com.example.pattern.strategy.promotion.*;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/16 7:47 下午
 * @since V1.0.0
 */
public class PromotionActiveTest {

    // 简单测试
    @Test
    public void test1() {
        PromotionActive promotionActive1111 = new PromotionActive(new CashStrategy());
        promotionActive1111.exec();

        PromotionActive promotionActive618 = new PromotionActive(new GroupStrategy());
        promotionActive618.exec();
    }

    // 普通业务调用情况
    @Test
    public void test2() {
        String promotionKey= "CASH";

        // 创建优惠活动
        PromotionActive promotionActive;
        if ("CASH".equals(promotionKey)) {
            promotionActive = new PromotionActive(new CashStrategy());
        } else if ("COUPON".equals(promotionKey)) {
            promotionActive = new PromotionActive(new CouponStrategy());
        } else if ("GROUP".equals(promotionKey)) {
            promotionActive = new PromotionActive(new GroupStrategy());
        } else {
            promotionActive = new PromotionActive(new EmptyStrategy());
        }

        // 执行活动
        promotionActive.exec();
    }

    // 采用设计模式后的调用(工厂+单例+策略)
    @Test
    public void test3() {
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getInstance(PromotionStrategyFactory.PromotionKey.GROUP);
        PromotionActive promotionActive = new PromotionActive(promotionStrategy);
        promotionActive.exec();
    }

}
