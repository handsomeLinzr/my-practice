package com.example.pattern.decorator.pancake.v2;

/**
 * Description: 煎饼抽象类
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 3:19 下午
 * @since V1.0.0
 */
public abstract class AbstractPancake {
    /**
     * 获取信息
     * @return
     */
    public abstract String getMsg();

    /**
     * 获取价格
     * @return
     */
    public abstract int getPrice();
}
