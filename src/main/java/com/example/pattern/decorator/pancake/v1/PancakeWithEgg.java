package com.example.pattern.decorator.pancake.v1;

/**
 * Description: 煎饼加1个鸡蛋
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 9:43 上午
 * @since V1.0.0
 */
public class PancakeWithEgg extends Pancake{
    @Override
    public String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
