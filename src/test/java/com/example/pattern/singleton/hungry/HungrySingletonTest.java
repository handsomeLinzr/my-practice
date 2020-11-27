package com.example.pattern.singleton.hungry;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 5:17 下午
 * @since V1.0.0
 */
public class HungrySingletonTest {

    @Test
    public void getInstance() {
        HungrySingleton h1 = HungrySingleton.getInstance();
        HungrySingleton h2 = HungrySingleton.getInstance();
        System.out.println(h1);
        System.out.println(h2);

        try {
            HungrySingleton hungrySingleton = (HungrySingleton) Class.forName("com.example.pattern.singleton.hungry.HungrySingleton").newInstance();
            System.out.println(hungrySingleton);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
