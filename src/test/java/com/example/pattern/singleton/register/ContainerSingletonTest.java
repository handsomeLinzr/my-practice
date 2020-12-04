package com.example.pattern.singleton.register;

import com.example.pattern.singleton.utils.ConcurrentExecutor;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 5:17 下午
 * @since V1.0.0
 */
public class ContainerSingletonTest {

    @Test
    public void test() throws Exception {
        ConcurrentExecutor.executor(() -> System.out.println(Thread.currentThread().getName() + ":" + ContainerSingleton.getBean("com.example.pattern.singleton.prac.InnerClass")),
                10, 4);

    }
}
