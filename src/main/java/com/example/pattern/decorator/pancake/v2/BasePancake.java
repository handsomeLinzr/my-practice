package com.example.pattern.decorator.pancake.v2;

/**
 * Description: 普通煎饼
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 3:20 下午
 * @since V1.0.0
 */
public class BasePancake extends AbstractPancake {
    @Override
    public String getMsg() {
        return "1个煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
