package com.example.pattern.decorator.pancake.v2;

/**
 * Description: 煎饼加1个鸡蛋
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 3:32 下午
 * @since V1.0.0
 */
public class EggPancake extends AbstractPancake {

    private AbstractPancake pancake;

    public EggPancake(AbstractPancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getMsg() {
        return this.pancake.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return this.pancake.getPrice() + 1;
    }
}
