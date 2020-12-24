package com.example.pattern.decorator.pancake.v1;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 9:44 上午
 * @since V1.0.0
 */
public class PancakeWithEggAndSausage extends PancakeWithEgg{
    @Override
    public String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
