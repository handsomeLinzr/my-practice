package com.example.pattern.strategy.pay;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付方式策略
 * @author LZR
 * @date 2020/12/17-0:03
 */
public class PaymentStrategy {

    public static final String ALI = "ALI";
    public static final String JD = "JD";
    public static final String WECHAT = "WECHAT";
    public static final String DEFAULT = ALI;

    // 初始化
    private static final Map<String, Payment> PAYMENT_MAP = new HashMap<>();
    static {
        PAYMENT_MAP.put(ALI, new AliPay());
        PAYMENT_MAP.put(JD, new JDPay());
        PAYMENT_MAP.put(WECHAT, new WechatPay());
    }

    // 选择支付方式策略
    public static Payment get(String payKey) {
        if (PAYMENT_MAP.containsKey(payKey)) {
            return PAYMENT_MAP.get(payKey);
        }
        return PAYMENT_MAP.get(DEFAULT);
    }


}
