package com.example.pattern.decorator.pancake.v2;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 3:34 下午
 * @since V1.0.0
 */
public class SausagePancake extends AbstractPancake {

    private AbstractPancake pancake;

    public SausagePancake(AbstractPancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getMsg() {
        return this.pancake.getMsg() + "+1根火腿";
    }

    @Override
    public int getPrice() {
        return this.pancake.getPrice() + 2;
    }
}
