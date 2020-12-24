package com.example.pattern.decorator;

import com.example.pattern.decorator.pancake.v1.Pancake;
import com.example.pattern.decorator.pancake.v1.PancakeWithEgg;
import com.example.pattern.decorator.pancake.v1.PancakeWithEggAndSausage;
import com.example.pattern.decorator.pancake.v2.AbstractPancake;
import com.example.pattern.decorator.pancake.v2.BasePancake;
import com.example.pattern.decorator.pancake.v2.EggPancake;
import com.example.pattern.decorator.pancake.v2.SausagePancake;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 9:46 上午
 * @since V1.0.0
 */
public class PancakeTest {

    @Test
    public void testV1() {
        Pancake pancake = new Pancake();
        System.out.println(pancake.getMsg() + ";价格：" + pancake.getPrice());

        PancakeWithEgg pancakeWithEgg = new PancakeWithEgg();
        System.out.println(pancakeWithEgg.getMsg() + "；价格：" + pancakeWithEgg.getPrice());

        PancakeWithEggAndSausage pancakeWithEggAndSausage = new PancakeWithEggAndSausage();
        System.out.println(pancakeWithEggAndSausage.getMsg() + "；价格：" + pancakeWithEggAndSausage.getPrice());

    }

    @Test
    public void testV2() {
        AbstractPancake basePancake = new BasePancake();
        System.out.printf("%s;价格：%s%n", basePancake.getMsg(), basePancake.getPrice());

        basePancake = new EggPancake(basePancake);
        basePancake = new SausagePancake(basePancake);
        basePancake = new SausagePancake(basePancake);
        System.out.printf("%s;价格：%s%n", basePancake.getMsg(), basePancake.getPrice());
    }

}
